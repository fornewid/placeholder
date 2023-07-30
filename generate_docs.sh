#!/bin/bash

# Fail on any error
set -ex

DOCS_ROOT=docs-gen

[ -d $DOCS_ROOT ] && rm -r $DOCS_ROOT
mkdir $DOCS_ROOT

# Clear out the old API docs
[ -d docs/api ] && rm -r docs/api
# Build the docs with dokka
./gradlew dokkaHtmlMultiModule --stacktrace

# Create a copy of our docs at our $DOCS_ROOT
cp -a docs/* $DOCS_ROOT

cp README.md $DOCS_ROOT/index.md
cp CONTRIBUTING.md $DOCS_ROOT/contributing.md

sed -i.bak 's/CONTRIBUTING.md/contributing/' $DOCS_ROOT/index.md
sed -i.bak 's/README.md//' $DOCS_ROOT/index.md

# Convert docs/xxx.md links to just xxx/
sed -i.bak 's/docs\/\([a-zA-Z-]*\).md/\1/' $DOCS_ROOT/index.md

# Finally delete all of the backup files
find . -name '*.bak' -delete
