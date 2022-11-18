SUMMARY = "Rapid YAML"
AUTHOR = "Joao Paulo Magalhaes"
HOMEPAGE = "https://github.com/biojppm/rapidyaml.git"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=11a6f80850f6993383976130ad87005e"

SRC_URI = "gitsm://github.com/biojppm/rapidyaml.git;branch=master;protocol=https"

inherit cmake

S = "${WORKDIR}/git"
PV = "v0.4.1"

SRCREV = "213b201d264139cd1b887790197e08850af628e3"

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"
