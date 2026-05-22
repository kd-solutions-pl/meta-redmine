SUMMARY = "QEMU Image running Redmine on read-only rootfs"
LICENSE = "MIT"

require recipes-core/images/albertow-image.bb

IMAGE_INSTALL:append = " \
    redmine \
"
