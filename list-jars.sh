#!/usr/bin/env bash
set -e

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
TMPFILE="$(mktemp)"

cd "$SCRIPT_DIR"

mvn -q dependency:build-classpath \
	-o \
	-Dmdep.outputFile="$TMPFILE" \
	-DincludeScope=runtime

tr ':' '\n' < "$TMPFILE" \
	| sed 's|.*/||' \
	| sort \
	> "$SCRIPT_DIR/jars.txt"

rm -f "$TMPFILE"

echo "Generated $SCRIPT_DIR/jars.txt"
