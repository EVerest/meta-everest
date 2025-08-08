LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://git@github.com/EVerest/everest-sqlite.git;branch=main;protocol=ssh \
           "

inherit everest_internal
inherit cmake

S = "${WORKDIR}/git"

SRCREV = "5dfc8c0e6a15462c25909fd04ee82a851a632b2a"

DEPENDS = "\
    everest-cmake \
    liblog \
    nlohmann-json \
    sqlite3 \
"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "\
    -DDISABLE_EDM=ON \
    -DEVEREST_SQLITE_INSTALL=ON \
    -DCMAKE_POSITION_INDEPENDENT_CODE=ON \
"

do_install:append() {
    install -d ${D}/usr/lib/cmake/everest-sqlite/cmake
    cp -a --no-preserve=ownership ${S}/cmake/*.cmake ${D}/usr/lib/cmake/everest-sqlite/cmake
}
