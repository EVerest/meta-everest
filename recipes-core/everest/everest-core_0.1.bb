LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-core.git;branch=main \
           "

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
"

S = "${WORKDIR}/git"

#SRCREV = "${AUTOREV}"
#SRCREV = "040d6d98e8fe858de3fe93a1083de1a4ffcb81d2"
SRCREV = "b263afee1a40dd405fc01b6f149026f63ea6ea23"
PV = "0.1+git${SRCPV}"

INSANE_SKIP_${PN} = "already-stripped useless-rpaths arch file-rdeps"

FILES_${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
