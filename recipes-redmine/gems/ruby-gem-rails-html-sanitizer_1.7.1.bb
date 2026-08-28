inherit ruby-gem
GEM_NAME = "rails-html-sanitizer"
SRC_URI[sha256sum] = "e797a7c9b01e567307e317c576b49ab4168017e63eea4dba9ce3cb587e2f22c2"
RDEPENDS:${PN} += "ruby-gem-loofah ruby-gem-nokogiri"
