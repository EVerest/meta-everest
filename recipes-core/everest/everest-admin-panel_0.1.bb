LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

inherit npm

SRC_URI = "git://github.com/EVerest/everest-admin-panel.git;branch=main;protocol=https \
           npmsw://${THISDIR}/${BPN}/everest-admin-panel-npm-shrinkwrap.json \
          "
S = "${WORKDIR}/git"

SRCREV = "b4ce1a2d2ac8d235be8f5dbf6eff0a2c44a7eb71"
PV = "0.1+git${SRCPV}"

FILES:${PN} += "${datadir}/everest/www/*"

do_compile[network] = "1"

do_compile() {
    npm install
    npm run build
}

do_install() {
    install -d ${D}/usr/share/everest/www
    cp -a --no-preserve=ownership ${S}/dist/* ${D}/usr/share/everest/www/
}

INSANE_SKIP:${PN} += "file-rdeps"
