LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libevse-security.git;branch=main;protocol=https \
           file://0001-Fix-cmake.patch \
"

inherit cmake

S = "${WORKDIR}/git"

SRCREV = "f621aab1d3e2d86a5d8dd0ab1fe56432a51c7c61"
PV = "0.1.0"

DEPENDS = "\
    everest-cmake \
    openssl \
    everest-log \
"

FILES_${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON -DEVSE_SECURITY_INSTALL=ON"
