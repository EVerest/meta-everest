LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-framework.git;branch=main;protocol=https \
           file://0001-Set-PYTHON_MODULE_EXTENSION-to-.so-to-avoid-pollutin.patch \
           file://0001-Fix-everestrs-build-in-yocto.patch \
           "

inherit python3native
inherit cmake
inherit pkgconfig
inherit logging

S = "${WORKDIR}/git"

SRCREV = "f97771efc234833fc5329054047e2429c9d1febe"

# FIXME (aw): due to nodejs dependency
do_configure[network] = "1"

DEPENDS = "\
    everest-cmake \
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
"

# disable everestrs rust support by default
PACKAGECONFIG ??= ""
PACKAGECONFIG[rust] = "-DEVEREST_ENABLE_RS_SUPPORT=ON -DFIND_CXXBRIDGE_BINARY=ON,-DEVEREST_ENABLE_RS_SUPPORT=OFF -DFIND_CXXBRIDGE_BINARY=OFF,cxxbridge-cmd-native,,,"

do_install:append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'rust', 'true', 'false', d)}; then
        bbnote "everest-framework rust support enabled"
        mkdir -p ${D}${datadir}/everest
        cp -R ${WORKDIR}/git/everestrs ${D}${datadir}/everest/
    else
        bbnote "everest-framework rust support disabled"
    fi
}
