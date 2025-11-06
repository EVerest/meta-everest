LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libslac.git;branch=main;protocol=https"

inherit cmake

SRCREV = "913412d0209f074b3df092f343bf0f9ac00edfce"

S = "${WORKDIR}/git"

DEPENDS = "everest-cmake"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
