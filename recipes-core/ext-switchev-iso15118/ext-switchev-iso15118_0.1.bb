LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/ext-switchev-iso15118.git;branch=everest;protocol=https \
           "
S = "${WORKDIR}/git"

SRCREV = "09c99358cf1c00aae7f92814b2aee27a0da27a26"
PV = "0.1+git${SRCPV}"

inherit cmake

DEPENDS = " \
    pip-environs \
    pip-pydantic \
    python3-psutil \
    python3-cryptography \
    pip-aiofile \
    pip-py4j \
    python3-netifaces \
    python3-dateutil \
"

RDEPENDS:${PN} = " \
    pip-environs \
    pip-pydantic \
    python3-psutil \
    python3-cryptography \
    pip-aiofile \
    pip-py4j \
    python3-netifaces \
    python3-dateutil \
"

EXTRA_OECMAKE += "-DTHIRD_PARTY_APP_DST=${libexecdir}/everest/3rd_party"
