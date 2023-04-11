FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "e089f6f2d06091def48ff610b099efb1c1a1aaca"
PV = "2.28.0"
SRC_URI = "git://github.com/EVerest/ext-mbedtls.git;protocol=https;branch=mbedtls-2.28.0-trustedCAKey"
SRC_URI += " \
    file://0001-Add-pkg-config-file.patch \
"

inherit pkgconfig
