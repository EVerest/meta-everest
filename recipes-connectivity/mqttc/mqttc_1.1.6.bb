SUMMARY = "A portable MQTT C client for embedded systems and PCs alike"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=9226377baf0b79174c89a1ab55592456"

SRC_URI = "git://github.com/LiamBindle/MQTT-C;protocol=http;branch=master;protocol=https \
           file://0001-Add-cmake-package-config.patch \
           "

SRCREV = "v1.1.6"

S = "${WORKDIR}/git"

inherit cmake
