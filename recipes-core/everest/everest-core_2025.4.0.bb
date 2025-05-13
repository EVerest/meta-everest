LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-core.git;branch=release/2025.4.0;protocol=https \
           file://everest.service \
           "

S = "${WORKDIR}/git"

SRCREV = "dbad407c7564e5a3a8238646cef42d38ac90b376"

do_compile[network] = "1"

inherit cmake pkgconfig systemd python3native

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
    libtimer \
    libslac \
    libevent \
    libevse-security \
    libcbv2g \
    libiso15118 \
    libnfc-nci \
    curl \
    everest-sqlite \
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

PACKAGECONFIG ??= "openssl"

PACKAGECONFIG[mbedtls] = "-DUSING_MBED_TLS=ON,-DUSING_MBED_TLS=OFF,mbedtls,,,openssl"
PACKAGECONFIG[openssl] = "-DUSING_MBED_TLS=OFF,-DUSING_MBED_TLS=ON,openssl,,,mbedtls"

do_install:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/everest.service ${D}${systemd_system_unitdir}/
    fi
}
