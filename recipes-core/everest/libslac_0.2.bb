LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libslac.git;branch=main;protocol=https"

inherit cmake

SRCREV = "ce7f609ebeee10fbe17113321272bdc966e14579"
PV = "0.2"

S = "${WORKDIR}/git"

DEPENDS = "everest-cmake"
