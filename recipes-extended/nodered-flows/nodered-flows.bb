DESCRIPTION = "Install Taco Nodered flows"
LICENSE = "CLOSED"
PR = "r1"

SRC_URI = "file://flows-all-chargers.json \
           file://flows.json \
           file://node_modules.tgz"

S = "${WORKDIR}"

FILES_${PN} += "/home/root/.node-red/flows-all-chargers.json \
               /home/root/.node-red/flows.json \
               /home/root/.node-red/node_modules/*"

do_install() {
        mkdir -p ${D}/home/root/.node-red/
        cp ${S}/flows-all-chargers.json ${D}/home/root/.node-red/
        cp ${S}/flows.json ${D}/home/root/.node-red/
        cp -r ${S}/node_modules ${D}/home/root/.node-red/
        rm -rf ${D}/home/root/.node-red/node_modules/.bin
}
