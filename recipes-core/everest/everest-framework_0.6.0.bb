LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-framework.git;branch=main;protocol=https"

inherit python3native
inherit cmake

S = "${WORKDIR}/git"

SRCREV = "df044f9a4d723a3e7f9ff9fe966c645b9b33c2c3"
PV = "0.6.0"

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
"

FILES_${PN} += "${libdir}/everest/* ${datadir}/everest/*"

EXTRA_OECMAKE += "\
    -DDISABLE_EDM=ON \
    -DNO_FETCH_CONTENT=ON \
    -DPYTHON_MODULE_EXTENSION=.so \
    -DPYBIND11_PYTHONLIBS_OVERWRITE=OFF \
    -DEVEREST_ENABLE_PY_SUPPORT=OFF \
"
