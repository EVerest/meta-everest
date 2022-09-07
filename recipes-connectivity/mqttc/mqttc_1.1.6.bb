SUMMARY = "A portable MQTT C client for embedded systems and PCs alike"
LICENSE = "MIT"

# LIC_FILES_CHKSUM = "file://LICENSE;md5=3adfcc70f5aeb7a44f3f9b495aa1fbf3"

SRC_URI = "git://github.com/LiamBindle/MQTT-C;protocol=http;branch=master;protocol=https \
           file://0001-Add-cmake-package-config.patch \
           "

SRCREV = "v1.1.6"

S = "${WORKDIR}/git"

inherit cmake
