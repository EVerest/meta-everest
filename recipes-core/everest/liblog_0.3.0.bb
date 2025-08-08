LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/liblog.git;branch=main;protocol=https"

inherit cmake
inherit everest_internal

DEPENDS = "\
    everest-cmake \
    boost \
"

S = "${WORKDIR}/git"

SRCREV = "08ff519b647beaa51f8f25ab04b88c079ca253a7"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += " \
    -DDISABLE_EDM=ON \
    -DCMAKE_POSITION_INDEPENDENT_CODE=ON \
"
