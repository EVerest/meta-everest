# The is automatic generated Code by "makePipRecipes.py"
# (build by Robin Sebastian (https://github.com/robseb) (git@robseb.de) Vers.: 1.2) 

SUMMARY = "Recipe to embedded the Python PiP Package pydantic"
HOMEPAGE ="https://pypi.org/project/pydantic"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c02ea30650b91528657db64baea1757"

inherit pypi setuptools3
PYPI_PACKAGE = "pydantic"
SRC_URI[md5sum] = "8338a8a0a3ac0df1df85766b7c76fa07"
SRC_URI[sha256sum] = "1ed987c3ff29fff7fd8c3ea3a3ea877ad310aae2ef9889a119e22d3f2db0691a"

RDEPENDS:${PN} = "python3-typing-extensions"

UPSTREAM_CHECK_REGEX = "/typing-extensions/(?P<pver>(\d+[\.\-_]*)+)/"

BBCLASSEXTEND = "native nativesdk"
