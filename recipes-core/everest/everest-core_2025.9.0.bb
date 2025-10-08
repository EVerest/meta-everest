LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-core.git;branch=main;protocol=https \
           file://everest.service \
           "

S = "${WORKDIR}/git"

SRCREV = "3beacf9bd5efe1109ff53f58a40f68582bfe99b3"

do_compile[network] = "0"

inherit cmake pkgconfig systemd python3native

DEPENDS = " \
    boost \
    curl \
    evcli-native \
    everest-cmake \
    everest-framework \
    everest-sqlite \
    libcbv2g \
    libevent \
    libevse-security \
    libfsm \
    libiso15118 \
    liblog \
    libnfc-nci \
    libocpp \
    libpcap \
    libslac \
    libtimer \
    mqttc \
    nodejs-native \
    openssl \
    pugixml \
    rsync-native \
    sdbus-c++ \
    sigslot \
"

RDEPENDS:${PN} += "libevent openssl"

INSANE_SKIP:${PN} = "already-stripped useless-rpaths arch file-rdeps"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += " \
    -DDISABLE_EDM=ON \
    -DNO_FETCH_CONTENT=ON \
    -DEVEREST_ENABLE_RUN_SCRIPT_GENERATION=OFF \
    -Deverest-core_INSTALL_EV_CLI_IN_PYTHON_VENV=OFF \
    -Deverest-core_USE_PYTHON_VENV=OFF \
    -DEV_SETUP_PYTHON_EXECUTABLE_USE_PYTHON_VENV=OFF \
"

SYSTEMD_SERVICE:${PN} = "everest.service"

do_install:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/everest.service ${D}${systemd_system_unitdir}/
    fi
}
