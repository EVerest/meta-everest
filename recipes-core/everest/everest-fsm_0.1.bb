LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libfsm.git;branch=main;protocol=https"

# SRCREV = "${AUTOREV}"
SRCREV = "7b5ab72710a321df1f86af0db91a0740cdf4e2ca"
PV = "0.1+git${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS = "everest-cmake"

inherit cmake
