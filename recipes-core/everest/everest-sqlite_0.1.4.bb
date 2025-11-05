LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://git@github.com/EVerest/everest-sqlite.git;branch=main;protocol=ssh \
           "

inherit cmake

S = "${WORKDIR}/git"

SRCREV = "85b31859f20255e1b96992ab35d40ebdb15d9c55"

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
