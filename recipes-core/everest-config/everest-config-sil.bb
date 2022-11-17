DESCRIPTION = "Install SIL config and systemd service"
LICENSE = "CLOSED"
PR = "r1"

SRC_URI = "file://config-sil.json \
           file://logging.ini \
           file://everest.service"

S = "${WORKDIR}"

FILES_${PN} += "/etc/everest/config-sil.json \
               /etc/everest/logging.ini \
               ${systemd_system_unitdir}/everest.service"

inherit systemd

SYSTEMD_AUTO_ENABLE_${PN} = "enable"
SYSTEMD_PACKAGES = "${PN}"

SYSTEMD_SERVICE_${PN} = "everest.service"

do_install() {
        mkdir -p ${D}/etc/everest/
        mkdir -p ${D}/etc/systemd/system
        cp ${S}/config-sil.json ${D}/etc/everest/config-sil.json
        cp ${S}/logging.ini ${D}/etc/everest/logging.ini
        install -d ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/everest.service ${D}${systemd_system_unitdir}
}
