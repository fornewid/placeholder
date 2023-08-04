#!/bin/bash
set -ex

# Generate API docs
./gradlew dokkaHtmlMultiModule --stacktrace

# Copy *.md files into docs directory
cp README.md docs/index.md
cp CONTRIBUTING.md docs/contributing.md

sed -i.bak 's/CONTRIBUTING.md/contributing/' docs/index.md

# Finally delete all of the backup files
find . -name '*.bak' -delete
