LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libslac.git;branch=main;protocol=https"

inherit cmake

# SRCREV = "${AUTOREV}"
SRCREV = "41bf85dd95c061ad1fe76565a3ccc93e34548b6a"
PV = "0.1+git${SRCPV}"

S = "${WORKDIR}/git"

DEPENDS = "everest-cmake"
