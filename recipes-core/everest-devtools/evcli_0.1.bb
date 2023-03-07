LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-utils.git;branch=main \
           file://0001-Dummy-setup.py.patch \
           "

#SRCREV = "${AUTOREV}"
SRCREV = "c675061b9fc17e8248a74056e7428093f1d35446"
PV = "0.1+git${SRCPV}"

S = "${WORKDIR}/git"

DISTUTILS_SETUP_PATH = "${S}/ev-dev-tools"

inherit setuptools3

do_configure_prepend() {
    cd ${DISTUTILS_SETUP_PATH}
}

do_compile_prepend() {
    cd ${DISTUTILS_SETUP_PATH}
}

do_install_prepend() {
    cd ${DISTUTILS_SETUP_PATH}
}

# FIXME (aw): this is really, really, hacky, we might interfere here with other python packages ...
do_install_append () {
    ${STAGING_BINDIR_NATIVE}/pip3 install ${S}/ev-dev-tools \
    --root=${D} \
    --prefix=${prefix}
}

DEPENDS = "python3-pip-native"
BBCLASSEXTEND = "native"
