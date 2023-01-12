LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-core.git;branch=main;protocol=https \
           "

S = "${WORKDIR}/git"

SRCREV = "21cad0c3b8474d71739ce8cec86a8876a801c1c3"
PV = "0.1+git${SRCPV}"

do_compile[network] = "1"


inherit cmake

DEPENDS = " \
    everest-cmake \
    boost \
    sigslot \
    pugixml \
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
    ext-switchev-iso15118 \
"

INSANE_SKIP:${PN} = "already-stripped useless-rpaths arch file-rdeps"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON -DNO_FETCH_CONTENT=ON -DEVEREST_PROJECT_DIRS=${S} -DEVEREST_ENABLE_PY_SUPPORT=ON"

do_install:append() {
    install -d ${D}/usr/lib/cmake/everest-core
    cp -a --no-preserve=ownership ${S}/cmake/*.cmake ${D}/usr/lib/cmake/everest-core/
    install -d ${D}/usr/lib/cmake/everest-core/assets
    cp -a --no-preserve=ownership ${S}/cmake/assets/logging.ini ${D}/usr/lib/cmake/everest-core/assets/
    cp -a --no-preserve=ownership ${S}/cmake/assets/run_nodered_template.sh.in ${D}/usr/lib/cmake/everest-core/assets/
    cp -a --no-preserve=ownership ${S}/cmake/assets/run_template.sh.in ${D}/usr/lib/cmake/everest-core/assets/
    install -d ${D}/usr/share/everest/interfaces
    cp -a --no-preserve=ownership ${S}/interfaces/*.yaml ${D}/usr/share/everest/interfaces/
    install -d ${D}/usr/share/everest/types
    cp -a --no-preserve=ownership ${S}/types/*.yaml ${D}/usr/share/everest/types/
}
