LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libfsm.git;branch=main;protocol=https"

# tag 0.2.0
SRCREV = "b31d5f97cc3e09186e21eddf8cb3bcb133d7bc3c"

S = "${WORKDIR}/git"

DEPENDS = "everest-cmake"

inherit cmake
