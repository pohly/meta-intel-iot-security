require ima-evm-utils.inc

# 0.9 was released without tagging it. Using the commit which says "Release version 0.9".
PV = "0.9+git${SRCPV}"
SRCREV = "3d9bdc1de282846de3523fd7a698d473304650b0"
SRC_URI = "git://git.code.sf.net/p/linux-ima/ima-evm-utils \
           file://0002-tpm_pcr_read-close-file-when-returning-early.patch \
           file://0003-ima_verify-ignore-n-flag.patch \
           file://0004-calc_evm_hmac-hash-avoid-fd-leak-when-ioctl-fails.patch \
           file://0001-add_dir_hash-fix-DIR-leak-in-case-of-failure.patch \
           "
S = "${WORKDIR}/git"

# Documentation depends on asciidoc, which we do not have, so
# do not build documentation.
SRC_URI += "file://disable-doc-creation.patch"

# Workaround for upstream incompatibility with older Linux distros.
# Relevant for us when compiling ima-evm-utils-native.
SRC_URI += "file://evmctl.c-do-not-depend-on-xattr.h-with-IMA-defines.patch"
