LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://git@github.com/EVerest/everest-sqlite.git;branch=main;protocol=ssh \
           "

inherit cmake

S = "${WORKDIR}/git"

SRCREV = "80f374bde3adafb9c946654e9e803749c7c2d9ca"

DEPENDS = "\
    everest-cmake \
    liblog \
    nlohmann-json \
    sqlite3 \
"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON -DEVEREST_SQLITE_INSTALL=ON"
