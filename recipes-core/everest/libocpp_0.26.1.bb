LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libocpp.git;branch=main;protocol=https \
           "

inherit cmake

S = "${WORKDIR}/git"

SRCREV = "32c788908ee7ae55b0ef5f4e076599766a842965"

DEPENDS = "\
    everest-cmake \
    boost \
    sqlite3 \
    openssl \
    libwebsockets \
    nlohmann-json \
    json-schema-validator \
    libfsm \
    liblog \
    libtimer \
    libevse-security \
    everest-sqlite \
"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
