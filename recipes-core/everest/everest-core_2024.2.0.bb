LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-core.git;branch=main;protocol=https \
           file://everest.service \
           "

S = "${WORKDIR}/git"

SRCREV = "3970ee3d85cad194e4efd52de7f84bc3b13503be"

do_compile[network] = "1"

inherit cmake pkgconfig systemd

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

EXTRA_OECMAKE += "-DDISABLE_EDM=ON -DNO_FETCH_CONTENT=ON -DEVEREST_ENABLE_RUN_SCRIPT_GENERATION=OFF"

SYSTEMD_SERVICE:${PN} = "everest.service"

do_install:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/everest.service ${D}${systemd_system_unitdir}/
    fi
}
