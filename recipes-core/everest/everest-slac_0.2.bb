LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libslac.git;branch=main;protocol=https"

inherit cmake

SRCREV = "486cd8b07e0654c2b5339d3ab40d07318967b7fd"
PV = "0.2"

S = "${WORKDIR}/git"

DEPENDS = "everest-cmake"
