inherit ruby-gem
GEM_NAME = "net-imap"
SRC_URI[sha256sum] = "96aa4ee50df3060203e649efc341f53480b791d49e150f2fdebf68beb141a8df"
RDEPENDS:${PN} += "ruby-gem-date ruby-gem-net-protocol"
