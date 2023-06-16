LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-utils.git;branch=main;protocol=https \
           "

SRCREV = "650dcf8a6b5010184d3480f90478a8228aa68615"
PV = "0.0.19"

S = "${WORKDIR}/git"

DISTUTILS_SETUP_PATH = "${S}/ev-dev-tools"

inherit setuptools3

do_configure_prepend() {
cat > ${DISTUTILS_SETUP_PATH}/setup.py <<-EOF
from setuptools import setup
if __name__ == '__main__':
    setup(
        name='ev-dev-tools',
        version='0.0.19',
        author='aw',
        description='This is an example project',
        long_description='Utilities for developing with the everest framework',
        url='https://github.com/EVerest/everest-utils',
        install_requires=['jinja2', 'jsonschema', 'stringcase', 'pyyaml'],
        package_dir={
            '': 'src',
        },
        packages = ['ev_cli'],
        package_data={
            'ev_cli': ['templates/*.j2'],
        },
        entry_points={
            'console_scripts': [
                'ev-cli=ev_cli.ev:main',
            ]
        }
    )
EOF
}

# FIXME (aw): this is really, really, hacky, we might interfere here with other python packages ...
# do_install_append () {
#     ${STAGING_BINDIR_NATIVE}/pip3 install ${S}/ev-dev-tools \
#     --root=${D} \
#     --prefix=${prefix}
# }

DEPENDS = "python3-pip-native"

RDEPENDS_${PN} = " \
    pip-stringcase \
    python3-jsonschema \
    python3-pyyaml \
    python3-jinja2 \
"

BBCLASSEXTEND = "native"
