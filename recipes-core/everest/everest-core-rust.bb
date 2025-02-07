LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

# SRCREV and SRC_URI is defined here because it's shared between
# everest-core and everest-core-rust
require everest-core.inc

# rust crate dependencies
require everest-core-rust-crates.inc

inherit cargo

S = "${WORKDIR}/git"

CARGO_SRC_DIR = "modules"

# list of EVerest modules relative to the modules directory to be built
EVEREST_MODULES = "RsPaymentTerminal RsIskraMeter rust_examples/RsExample rust_examples/RsExampleUser"

DEPENDS = "\
    everest-framework \
"

FILES:${PN} += "${libdir}/everest/* ${datadir}/everest/*"

# needed for zvt dependency of RsPaymentTerminal
do_compile[network] = "1"
# also needed for zvt_feig_terminal depenency of RsPaymentTerminal
# cargo from meta-lts-mixins does not like the git dependency of RsPaymentTerminal
CARGO_BUILD_FLAGS:remove = "--frozen"

do_configure:prepend() {
    export EVEREST_LIB_DIR="${STAGING_DIR_TARGET}/usr/lib/"
    export EVEREST_RS_FRAMEWORK_BINARY_LOCATION="${STAGING_DIR_TARGET}/usr/lib/"
}

do_compile:prepend() {
    export EVEREST_LIB_DIR="${STAGING_DIR_TARGET}/usr/lib/"
    export EVEREST_RS_FRAMEWORK_BINARY_LOCATION="${STAGING_DIR_TARGET}/usr/lib/"
    export EVEREST_CORE_ROOT="${WORKDIR}/git"
    EVERESTRS_LOCATION="${STAGING_DIR_TARGET}/${datadir}/everest/everestrs"
    if [ ! -d "${EVERESTRS_LOCATION}" ]; then
        bbfatal "Could not find location of everestrs. Did you enable rust support in everest-framework PACKAGECONFIG?"
    fi
    echo "[workspace]" > ${WORKDIR}/git/modules/Cargo.toml
    echo "resolver = \"2\"" >> ${WORKDIR}/git/modules/Cargo.toml
    echo "members = [" >> ${WORKDIR}/git/modules/Cargo.toml
    for EVEREST_MODULE in ${EVEREST_MODULES}
    do
        echo "  \"${EVEREST_MODULE}\"," >> ${WORKDIR}/git/modules/Cargo.toml
    done
    echo "]" >> ${WORKDIR}/git/modules/Cargo.toml
    echo "[workspace.dependencies]" >> ${WORKDIR}/git/modules/Cargo.toml
    echo "everestrs = { path = \"${STAGING_DIR_TARGET}/${datadir}/everest/everestrs/everestrs\" }" >> ${WORKDIR}/git/modules/Cargo.toml
    echo "everestrs-build = { path = \"${STAGING_DIR_TARGET}/${datadir}/everest/everestrs/everestrs-build\" }" >> ${WORKDIR}/git/modules/Cargo.toml
}

# By default cargo installs the modules into /usr/bin which we do not want and fix here
do_install:append(){
    INSTALLED_BIN=$(ls -l "${D}/usr/bin/")
    for EVEREST_MODULE_PATH in ${EVEREST_MODULES}
    do
        EVEREST_MODULE=$(basename ${EVEREST_MODULE_PATH})
        bbnote "Installing EVerest Rust module: ${EVEREST_MODULE}"
        mkdir -p ${D}/usr/libexec/everest/modules/${EVEREST_MODULE}
        mv ${D}/usr/bin/${EVEREST_MODULE} ${D}/usr/libexec/everest/modules/${EVEREST_MODULE}
        cp ${WORKDIR}/git/modules/${EVEREST_MODULE_PATH}/manifest.yaml ${D}/usr/libexec/everest/modules/${EVEREST_MODULE}
    done

    rm -r ${D}/usr/bin/
}
