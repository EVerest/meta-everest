FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRCREV = "a941d28381e98384552cc3fa6890de4f1e57c721"
PV = "2.28.0"
SRC_URI = "git://github.com/EVerest/ext-mbedtls.git;protocol=https;branch=mbedtls-2.28.0-trustedCAKey"
SRC_URI += " \
    file://0001-Add-pkg-config-file.patch \
"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

inherit pkgconfig
