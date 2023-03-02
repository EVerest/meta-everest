LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libocpp.git;branch=main;protocol=https"

inherit cmake

S = "${WORKDIR}/git"

SRCREV = "58d7340a314b145bc23921a6d6377e160de63a5f"
PV = "0.5.1"

DEPENDS = "\
    everest-cmake \
    boost \
    sqlite3 \
    openssl \
    websocketpp \
    nlohmann-json \
    json-schema-validator \
    libfsm \
    liblog \
    libtimer \
"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
