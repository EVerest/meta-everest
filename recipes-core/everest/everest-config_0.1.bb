LICENSE = "CLOSED"


SRC_URI = "file://config.json \
           file://logging.ini \
           "

do_install_append() {
    install -d ${D}/usr/share/everest/config
    install -o root -g root -m 0644 ${WORKDIR}/config.json  ${D}/usr/share/everest/config/
    install -o root -g root -m 0644 ${WORKDIR}/logging.ini  ${D}/usr/share/everest/config/
}

FILES_${PN} += " /usr/share/everest/config"
