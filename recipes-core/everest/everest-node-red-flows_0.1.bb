LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

inherit npm

DEPENDS = "node-red"

SRC_URI = "file://package.json \
           npmsw://${THISDIR}/${BPN}/everest-node-red-flows-npm-shrinkwrap.json \
           file://flows.json \
          "
S = "${WORKDIR}"

FILES:${PN} += "/home/root/.node-red/flows.json \
               /home/root/.node-red/node_modules/*"

do_install() {
    mkdir -p ${D}/home/root/.node-red/
    cp ${S}/flows.json ${D}/home/root/.node-red/
    cp -a --no-preserve=ownership ${S}/node_modules ${D}/home/root/.node-red/
    rm -rf ${D}/home/root/.node-red/node_modules/.bin
}

INSANE_SKIP:${PN} = "already-stripped useless-rpaths arch file-rdeps staticdev"

EXCLUDE_FROM_SHLIBS = "1"
