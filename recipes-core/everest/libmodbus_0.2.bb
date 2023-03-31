LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libmodbus.git;branch=main;protocol=https"

inherit cmake

S = "${WORKDIR}/git"

SRCREV = "9d9326f64bceb2b2ea5f73e203c52f95ca62509a"
PV = "0.2"

DEPENDS = "\
    everest-cmake \
    boost \
    liblog \
"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
