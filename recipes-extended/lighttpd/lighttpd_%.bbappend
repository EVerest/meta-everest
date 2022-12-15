FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://index.html \
    file://lighttpd.conf \
    file://01-dirlisting.conf \
    file://01-mime-types.conf \
"

do_install:append() {
    # empty /var/www/html dir
    rm -rf ${D}/var/www
    install -d ${D}/var/www/html

    install -m 0644 ${WORKDIR}/index.html ${D}/var/www/html/index.html

    install -d ${D}/etc/lighttpd/conf-enabled/
    install -m 0644 ${WORKDIR}/lighttpd.conf ${D}/etc/lighttpd/lighttpd.conf
    install -m 0644 ${WORKDIR}/01-dirlisting.conf ${D}/etc/lighttpd/conf-enabled/01-dirlisting.conf
    install -m 0644 ${WORKDIR}/01-mime-types.conf ${D}/etc/lighttpd/conf-enabled/01-mime-types.conf
}

FILES:${PN} += " /var/www/html/index.html \
                 /etc/lighttpd/lighttpd.conf \
                 /etc/lighttpd/conf-enabled/01-dirlisting.conf \
                 /etc/lighttpd/conf-enabled/01-mime-types.conf \
               "
