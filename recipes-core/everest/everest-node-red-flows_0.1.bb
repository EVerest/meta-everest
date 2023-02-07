LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${THISDIR}/${BPN}/LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

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
