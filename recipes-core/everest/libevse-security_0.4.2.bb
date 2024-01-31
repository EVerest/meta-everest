LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libevse-security.git;branch=main;protocol=https"

inherit cmake

S = "${WORKDIR}/git"

SRCREV = "5afe436231a017f7c7ce4822d20c964b48e9ae40"

DEPENDS = "\
    everest-cmake \
    openssl \
    liblog \
"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON -DEVSE_SECURITY_INSTALL=ON"
