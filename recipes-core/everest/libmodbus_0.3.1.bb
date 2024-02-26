LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libmodbus.git;branch=main;protocol=https"

inherit cmake

S = "${WORKDIR}/git"

# tag v0.3.1
SRCREV = "9e414f3825dfb9d8772ea055b01a053d188d3c65"

DEPENDS = "\
    everest-cmake \
    boost \
    liblog \
"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
