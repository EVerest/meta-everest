# The is automatic generated Code by "makePipRecipes.py"
# (build by Robin Sebastian (https://github.com/robseb) (git@robseb.de) Vers.: 1.2) 

SUMMARY = "Recipe to embedded the Python PiP Package aiofile"
HOMEPAGE ="https://pypi.org/project/aiofile"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENCE.md;md5=d8d1d59c60e60e8627fcd1c350a5c904"

inherit pypi setuptools3
PYPI_PACKAGE = "aiofile"
SRC_URI[md5sum] = "e7517c2f0205fb4190aa1b26acbbe399"
SRC_URI[sha256sum] = "1623b98d88fbd16bbd2808d010de4e185a700e950ed3f17455dd851aa2455f40"

RDEPENDS:${PN} = " \
    pip-caio \
"
