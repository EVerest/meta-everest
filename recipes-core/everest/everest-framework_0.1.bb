LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-framework.git;branch=main;protocol=https  \
           "
inherit cmake python3native

S = "${WORKDIR}/git"

SRCREV = "3de408249c368c1714d27cc71da776457f140d8b"
PV = "0.1+git${SRCPV}"

# FIXME (aw): due to nodejs dependency
do_configure[network] = "1"

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
    rapidyaml \
    libwebsockets \
    python3-pybind11 \
    python3-pybind11-json \
"

FILES:${PN} += "${libdir}/everest/* ${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON -DNO_FETCH_CONTENT=ON -DEVEREST_ENABLE_PY_SUPPORT=ON "
