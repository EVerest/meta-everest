LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libevse-security.git;branch=main;protocol=https \
           "

inherit cmake

S = "${WORKDIR}/git"

# will be v0.9.9
SRCREV = "71870efd97bd276a21a9513baa8cc3e79b5f4665"

DEPENDS = "\
    date \
    everest-cmake \
    liblog \
    libtimer \
    openssl \
"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON -DEVSE_SECURITY_INSTALL=ON -DLIBEVSE_SECURITY_BUILD_TESTING=OFF"
OECMAKE_CXX_FLAGS += "-Wno-narrowing"

# Add TPM2 support
EXTRA_OECMAKE:append = "${@bb.utils.contains('DISTRO_FEATURES', 'tpm2', ' -DUSING_TPM2=ON', '', d)}"
