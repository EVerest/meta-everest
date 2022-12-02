LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-utils.git;branch=main;protocol=https \
           file://0001-Dummy-setup.py.patch \
           "

# SRCREV = "${AUTOREV}"
SRCREV = "077803137272431aabf290ce1736210ec3e9d8fe"
PV = "0.1+git${SRCPV}"

S = "${WORKDIR}/git"

# DISTUTILS_SETUP_PATH = "${S}/ev-dev-tools"
SETUPTOOLS_SETUP_PATH = "${S}/ev-dev-tools"

inherit setuptools3_legacy


# do_configure:prepend() {
#     cd ${DISTUTILS_SETUP_PATH}
# }

# do_compile:prepend() {
#     cd ${DISTUTILS_SETUP_PATH}
# }

# do_install:prepend() {
#     cd ${DISTUTILS_SETUP_PATH}
# }

# FIXME (aw): this is really, really, hacky, we might interfere here with other python packages ...
# do_install:append () {
#     ${STAGING_BINDIR_NATIVE}/pip3 install ${S}/ev-dev-tools \
#     --root=${D} \
#     --prefix=${prefix}
# }

DEPENDS = "python3-pip-native"
RDEPENDS:${PN} = "pip-stringcase python3-jsonschema python3-pyyaml python3-jinja2"
BBCLASSEXTEND = "native"
