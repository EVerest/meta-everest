FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://mosquitto.conf"

FILES_${PN} += "${sysconfdir}/mosquitto/mosquitto.conf"

do_install_append() {
    install -m 0644 ${WORKDIR}/mosquitto.conf ${D}${sysconfdir}/mosquitto/mosquitto.conf
}
