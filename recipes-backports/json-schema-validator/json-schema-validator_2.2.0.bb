SUMMARY = "JSON schema validator for JSON for Modern C++"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c441d022da1b1663c70181a32225d006"

SRC_URI = "git://github.com/pboettch/json-schema-validator;branch=main;protocol=https \
          "

SRCREV = "6b17782d6a5d1dee5d2c4fc5d25ffb1123913431"

S = "${WORKDIR}/git"

DEPENDS += "nlohmann-json"

inherit cmake
EXTRA_OECMAKE = "-DCMAKE_POSITION_INDEPENDENT_CODE=ON -DJSON_VALIDATOR_BUILD_EXAMPLES=OFF -DJSON_VALIDATOR_BUILD_TESTS=OFF -DJSON_VALIDATOR_INSTALL=ON -DJSON_VALIDATOR_BUILD_SHARED_LIBS=ON"

TARGET_CFLAGS += "-Wno-narrowing"
