# The is automatic generated Code by "makePipRecipes.py"
# (build by Robin Sebastian (https://github.com/robseb) (git@robseb.de) Vers.: 1.2) 

SUMMARY = "Recipe to embedded the Python PiP Package environs"
HOMEPAGE ="https://pypi.org/project/environs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a49f11890d809ccbf7d326a2df842aaf"

inherit pypi setuptools3
PYPI_PACKAGE = "environs"
SRC_URI[md5sum] = "7df5cb194ff30a004e1f03d9b4fdbee6"
SRC_URI[sha256sum] = "a76307b36fbe856bdca7ee9161e6c466fd7fcffc297109a118c59b54e27e30c9"

RDEPENDS:${PN} = " \
    python3-marshmallow \
    pip-python-dotenv \
"
