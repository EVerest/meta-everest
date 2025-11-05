LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-framework.git;branch=main;protocol=https \
           "

# ensures the everestpy python bindings build properly
inherit python3targetconfig

inherit cmake
inherit pkgconfig

S = "${WORKDIR}/git"

SRCREV = "059e95ca6cdd23f318259a87480c0b1f48d0cf72"

# FIXME (aw): due to nodejs dependency
do_configure[network] = "1"

DEPENDS = "\
    everest-cmake \
    everest-sqlite \
    boost \
    websocketpp \
    nlohmann-json \
    json-schema-validator \
    mqttc \
    liblog \
    fmt \
    date \
    catch2 \
    nodejs-native \
    rapidyaml \
    libwebsockets \
    python3-pybind11 \
    python3-pybind11-json \
    libcap \
"

FILES:${PN} += "${libdir}/everest/* ${datadir}/everest/*"

EXTRA_OECMAKE += "\
    -DDISABLE_EDM=ON \
    -DNO_FETCH_CONTENT=ON \
    -DPYTHON_MODULE_EXTENSION=.so \
    -DPYBIND11_PYTHONLIBS_OVERWRITE=OFF \
    -DEVEREST_INSTALL_ADMIN_PANEL=OFF \
    -DCMAKE_POSITION_INDEPENDENT_CODE=ON \
"
