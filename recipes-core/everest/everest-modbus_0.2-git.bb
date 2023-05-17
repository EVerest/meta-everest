LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libmodbus.git;branch=main;protocol=https"

inherit cmake

S = "${WORKDIR}/git"

SRCREV = "2e899511c75551a5414d265c62f0d77cd9b61ca4"
PV = "0.2-git"

DEPENDS = "\
    everest-cmake \
    boost \
    everest-log \
"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
