LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libsunspec.git;branch=main;protocol=https"

inherit cmake

DEPENDS = "\
    everest-cmake \
    boost \
    nlohmann-json \
    everest-log \
    everest-modbus \
"

S = "${WORKDIR}/git"

SRCREV = "97a42e9dba26c068a34453ad0d9a0ce29595bf4d"
PV = "0.2"

FILES_${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
