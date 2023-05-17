LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libslac.git;branch=main;protocol=https"

inherit cmake

SRCREV = "fee9f12c532bc2f51069d3a1402564426ccdca19"
PV = "0.1"

S = "${WORKDIR}/git"

DEPENDS = "everest-cmake"
