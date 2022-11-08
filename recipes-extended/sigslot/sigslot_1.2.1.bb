SUMMARY = "Sigslot, a signal-slot library"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=8e23355f85e3828bb4ed474a2df2f9b9"

SRC_URI = "git://github.com/palacaze/sigslot.git;branch=master;protocol=https \
           "

SRCREV = "e41c6e62edfa67b6402b17a627dca698a14f47a8"

S = "${WORKDIR}/git"

inherit cmake
