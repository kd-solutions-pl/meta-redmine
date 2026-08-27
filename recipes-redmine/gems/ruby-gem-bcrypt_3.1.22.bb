inherit ruby-gem
GEM_NAME = "bcrypt"
SRC_URI[sha256sum] = "1f0072e88c2d705d94aff7f2c5cb02eb3f1ec4b8368671e19112527489f29032"

INSANE_SKIP:${PN} += "buildpaths"
