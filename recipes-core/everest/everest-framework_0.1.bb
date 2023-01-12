LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-framework.git;branch=main;protocol=https  \
           "
inherit cmake

S = "${WORKDIR}/git"

SRCREV = "03cc7d84df48d11899a4ce991589bfbf13e8c78f"
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
EXTRA_OECMAKE += "-DEVEREST_CROSS_PYTHON_INCLUDE_DIRS=${STAGING_DIR_TARGET}/usr/include/python3.10 "
EXTRA_OECMAKE += "-DEVEREST_CROSS_PYTHON_LIBRARIES=${STAGING_DIR_TARGET}/usr/lib/libpython3.10.so "
