LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
SRC_URI = "file://everest.service \
           "

inherit systemd

RDEPENDS:${PN} += "everest-core"

INSANE_SKIP:${PN} = "already-stripped useless-rpaths arch file-rdeps"

FILES:${PN} += "${datadir}/everest/*"

SYSTEMD_SERVICE:${PN} = "everest.service"

do_install() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/everest.service ${D}${systemd_system_unitdir}/
    fi
}
