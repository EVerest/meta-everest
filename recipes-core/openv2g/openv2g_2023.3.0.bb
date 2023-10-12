
LICENSE = "LGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e6a600fd5e1d9cbde2d983680233ad02"

inherit cmake

SRC_URI = "git://github.com/EVerest/ext-openv2g.git;protocol=https;branch=everest"

SRCREV = "35c0c0a4ff3412e588ff6f00561df1407916832d"

PV = "2023.3.0"
S = "${WORKDIR}/git"

DEPENDS = " \
    everest-cmake \
    "

DEFAULT_PREFERENCE = "1"
