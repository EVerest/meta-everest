# The is automatic generated Code by "makePipRecipes.py"
# (build by Robin Sebastian (https://github.com/robseb) (git@robseb.de) Vers.: 1.2) 

SUMMARY = "Recipe to embedded the Python PiP Package py4j"
HOMEPAGE ="https://pypi.org/project/py4j"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b2fa8304695a3a1a80a0ad6b3d4a6e4b"

inherit pypi setuptools3
PYPI_PACKAGE = "py4j"
SRC_URI[md5sum] = "e3adeb24698e2f0f7b74877b0ac5ea00"
SRC_URI[sha256sum] = "0b6e5315bb3ada5cf62ac651d107bb2ebc02def3dee9d9548e3baac644ea8dbb"

FILES:${PN} += "${datadir}/py4j/*"
