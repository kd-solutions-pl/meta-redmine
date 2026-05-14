inherit ruby-gem
GEM_NAME = "irb"
SRC_URI[sha256sum] = "c457f1f2f1438ae9ce5c5be3981ae2138dec7fb894c7d73777eeeb0a6c0d0752"
RDEPENDS:${PN} += "ruby-gem-reline"
