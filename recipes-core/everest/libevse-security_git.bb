LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libevse-security.git;branch=main;protocol=https \
           "

inherit cmake

S = "${WORKDIR}/git"

# tag git
SRCREV = "bce1ba42e0b39f56d537c68d7c3a9419b711c00b"

DEPENDS = "\
    date \
    everest-cmake \
    liblog \
    libtimer \
    openssl \
"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON -DEVSE_SECURITY_INSTALL=ON -DLIBEVSE_SECURITY_BUILD_TESTING=OFF"
