LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " crate://crates.io/anstyle/1.0.4 \
            crate://crates.io/clap/4.4.7 \
            crate://crates.io/clap_builder/4.4.7 \
            crate://crates.io/clap_lex/0.6.0 \
            crate://crates.io/codespan-reporting/0.11.1 \
            crate://crates.io/cxxbridge-cmd/1.0.110 \
            crate://crates.io/proc-macro2/1.0.69 \
            crate://crates.io/quote/1.0.33 \
            crate://crates.io/strsim/0.10.0 \
            crate://crates.io/syn/2.0.38 \
            crate://crates.io/termcolor/1.3.0 \
            crate://crates.io/unicode-ident/1.0.12 \
            crate://crates.io/unicode-width/0.1.11 \
            crate://crates.io/winapi/0.3.9 \
            crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
            crate://crates.io/winapi-util/0.1.6 \
            crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
           "

inherit cargo

S = "${WORKDIR}/cxxbridge-cmd-1.0.110"

CARGO_SRC_DIR = ""

BBCLASSEXTEND = "native"
