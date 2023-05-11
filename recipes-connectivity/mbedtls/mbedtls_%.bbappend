FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "ef1a43f80ce630c48eb9366410275b6fdf2c51a2"
PV = "2.28.0"
SRC_URI = "git://github.com/EVerest/ext-mbedtls.git;protocol=https;branch=mbedtls-2.28.0-trustedCAKey"
SRC_URI += " \
    file://0001-Add-pkg-config-file.patch \
"

inherit pkgconfig
