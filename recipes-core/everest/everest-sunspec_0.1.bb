LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libsunspec.git;branch=main;protocol=https"

inherit cmake

DEPENDS = "\
    everest-cmake \
    boost \
    nlohmann-json \
    everest-log \
    everest-modbus \
"

S = "${WORKDIR}/git"

# SRCREV = "${AUTOREV}"
SRCREV = "6a53a103fbff71f2307a02853cfa20e20928b506"
PV = "0.1+git${SRCPV}"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
