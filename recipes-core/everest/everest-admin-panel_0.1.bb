LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${THISDIR}/${BPN}/LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "https://github.com/EVerest/everest-admin-panel/releases/download/manually_dispatched/everest-admin-panel.tar.gz \
          "
SRC_URI[sha256sum] = "685d0f58a1b4501667b98d967c9f7b99ce699d02caccef47a05521f37648ef50"

PV = "0.1"

FILES:${PN} += "${datadir}/everest/www/*"

do_install() {
    install -d ${D}/usr/share/everest/www
    cp -a --no-preserve=ownership ${S} ${D}/usr/share/everest/www/
}

INSANE_SKIP:${PN} += "file-rdeps"
