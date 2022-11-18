LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libmodbus.git;branch=main;protocol=https"

inherit cmake

S = "${WORKDIR}/git"

#SRCREV = "${AUTOREV}"
SRCREV = "0f3151d0c340ed464dd83365c588e6b0e4e86bf4"
PV = "0.1+git${SRCPV}"

DEPENDS = "\
    everest-cmake \
    boost \
    everest-log \
"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
