LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-core.git;branch=main;protocol=https \
           file://0001-Enable-c-17-for-slac-fsm-in-staging.patch \
           "

S = "${WORKDIR}/git"

SRCREV = "9de06ab715321f91280ea1c8a00d284a15fb60c5"
PV = "2023.9.1"

do_compile[network] = "1"

inherit cmake pkgconfig

DEPENDS = " \
    everest-cmake \
    boost \
    sigslot \
    pugixml \
    libpcap \
    evcli-native \
    rsync-native \
    nodejs-native \
    everest-framework \
    everest-ocpp \
    everest-fsm \
    everest-log \
    everest-modbus \
    everest-sunspec \
    everest-slac \
    libevent \
    mbedtls \
    openv2g \
"

RDEPENDS_${PN} += "openv2g libevent mbedtls"

INSANE_SKIP_${PN} = "already-stripped useless-rpaths arch file-rdeps"

FILES_${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON -DNO_FETCH_CONTENT=ON -DEVEREST_ENABLE_PY_SUPPORT=OFF"
