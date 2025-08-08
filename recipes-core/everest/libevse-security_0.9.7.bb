LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libevse-security.git;branch=main;protocol=https \
           "

inherit everest_internal
inherit cmake

S = "${WORKDIR}/git"

SRCREV = "9f246bcca44ffe18212e919273bce281e07f3d7f"

DEPENDS = "\
    date \
    everest-cmake \
    liblog \
    libtimer \
    openssl \
"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON -DEVSE_SECURITY_INSTALL=ON -DLIBEVSE_SECURITY_BUILD_TESTING=OFF"
OECMAKE_CXX_FLAGS += "-Wno-narrowing"
