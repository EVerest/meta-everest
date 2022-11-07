LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/liblog.git;branch=main;protocol=https"

inherit cmake

DEPENDS = "\
    everest-cmake \
    boost \
"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
PV = "0.1+git${SRCPV}"

FILES_${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += " \
    -DCMAKE_POSITION_INDEPENDENT_CODE=ON \
"
