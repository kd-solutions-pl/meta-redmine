# frozen_string_literal: true

# Bundler is used here only to resolve Redmine dependencies against the gems
# already built and staged by Yocto, so that the recipe can generate a
# deterministic Gemfile.lock.
#
# Some staged gemspecs describe native extension build scripts, such as
# extconf.rb, through Gem::Specification#extensions. Those extensions were
# already built by the individual ruby-gem-* recipes. Keeping the declarations
# in the temporary gemspec copies can make Bundler treat the gems as needing
# extension build/install handling while this recipe is only producing a
# lockfile.
#
# This helper mutates only the temporary gemspec copies under the directory
# passed on the command line. It does not modify the real gemspecs in the
# recipe sysroot or the packaged gems.

root = ARGV.fetch(0)

Dir.glob(File.join(root, '**', '*.gemspec')).each do |path|
  spec = Gem::Specification.load(path)
  next unless spec

  spec.extensions = []
  File.write(path, spec.to_ruby)
end
