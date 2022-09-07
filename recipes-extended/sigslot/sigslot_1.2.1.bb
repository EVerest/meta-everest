SUMMARY = "Sigslot, a signal-slot library"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=8e23355f85e3828bb4ed474a2df2f9b9"

SRC_URI = "git://github.com/palacaze/sigslot.git;branch=master \
           "

SRCREV = "v1.2.1"

S = "${WORKDIR}/git"

inherit cmake
