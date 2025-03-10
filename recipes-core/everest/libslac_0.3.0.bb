LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libslac.git;branch=main;protocol=https"

inherit cmake

SRCREV = "1f9f1a114c8dec79607abaee18782e03849573d8"
PV = "0.3"

S = "${WORKDIR}/git"

DEPENDS = "everest-cmake"
