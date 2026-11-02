inherit ruby-gem
GEM_NAME = "actionview"
SRC_URI[sha256sum] = "eff1efd07c4d969abad288322b423bcb67fdbab5e324c91ca37352b80f226076"
RDEPENDS:${PN} += "ruby-gem-activesupport ruby-gem-builder ruby-gem-erubi ruby-gem-rails-dom-testing ruby-gem-rails-html-sanitizer"
