LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-framework.git;branch=main;protocol=https"

inherit cmake

S = "${WORKDIR}/git"

#SRCREV = "${AUTOREV}"
SRCREV = "0576ad133921a6fea4e6fba4bb86f1d0a7941b20"
PV = "0.1+git${SRCPV}"

DEPENDS = "\
    everest-cmake \
    boost \
    websocketpp \
    nlohmann-json \
    json-schema-validator \
    mqttc \
    everest-log \
    fmt \
    date \
    catch2 \
    nodejs-native \
"

FILES_${PN} += "${libdir}/everest/* ${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
