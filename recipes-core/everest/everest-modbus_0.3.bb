LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libmodbus.git;branch=main;protocol=https"

inherit cmake

S = "${WORKDIR}/git"

SRCREV = "b41adccde9036f7728785185db9c980a2fe94ef1"
PV = "0.3"

DEPENDS = "\
    everest-cmake \
    boost \
    everest-log \
"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
