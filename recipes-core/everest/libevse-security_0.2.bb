LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libevse-security.git;branch=main;protocol=https \
"

inherit cmake

S = "${WORKDIR}/git"

SRCREV = "fb097c945812a738def096e44a66a895b2c052a0"
PV = "0.2.0"

DEPENDS = "\
    everest-cmake \
    openssl \
    liblog \
"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON -DEVSE_SECURITY_INSTALL=ON"
