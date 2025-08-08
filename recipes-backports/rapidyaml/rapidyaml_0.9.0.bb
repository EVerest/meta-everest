SUMMARY = "Rapid YAML"
AUTHOR = "Joao Paulo Magalhaes"
HOMEPAGE = "https://github.com/biojppm/rapidyaml.git"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=11a6f80850f6993383976130ad87005e"

SRC_URI = "gitsm://github.com/biojppm/rapidyaml.git;branch=master;protocol=https"

inherit cmake

S = "${WORKDIR}/git"
PV = "v0.9.0"

SRCREV = "47ec2fa184209687c20fd5bc05621e1cb1200311"

EXTRA_OECMAKE += "-DBUILD_SHARED_LIBS=ON"
