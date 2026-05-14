inherit ruby-gem
GEM_NAME = "bcrypt"
SRC_URI[sha256sum] = "8410f8c7b3ed54a3c00cd2456bf13917d695117f033218e2483b2e40b0784099"

INSANE_SKIP:${PN} += "buildpaths"
