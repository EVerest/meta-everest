LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-core.git;branch=EV-382-TPM-based-CSR-interface-adaptations;protocol=https \
           "

S = "${WORKDIR}/git"

SRCREV = "8ad372bc903797f273fcfec8c56307f7ff5487ff"
PV = "2023.12.0"

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
    libocpp \
    libfsm \
    liblog \
    libmodbus \
    libsunspec \
    libslac \
    libevent \
    libevse-security \
    mbedtls \
    openv2g \
    curl \
"

RDEPENDS:${PN} += "openv2g libevent mbedtls"

INSANE_SKIP:${PN} = "already-stripped useless-rpaths arch file-rdeps"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON -DNO_FETCH_CONTENT=ON"
