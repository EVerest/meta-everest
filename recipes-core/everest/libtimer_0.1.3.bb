LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libtimer.git;branch=main;protocol=https"

inherit cmake

S = "${WORKDIR}/git"

SRCREV = "8b67a8eb17de70198e4e47ee8ed533c99fd25cc2"

DEPENDS = "\
    everest-cmake \
    boost \
    date \
"

EXTRA_OECMAKE += " \
    -DDISABLE_EDM=ON \
    -DBUILD_EXAMPLES=OFF \
"
