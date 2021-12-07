#!/bin/sh

cat reporttype-values.md | \
    grep -v '</strong></p>' | grep 'odd\|even' -C 12  | \
    grep -o '##[a-zA-Z0-9 ]\+\|[A-Z0-9]\+_[A-Z0-9_]\+</p>\|<br>[A-Z0-9]\+_[A-Z0-9_]\+\|\(JSON\|XML\|Comma\|Tab\|PDF\|xlsx\)' | uniq | \
    sed 's/## \([a-zA-Z0-9 ]*[a-zA-Z0-9]\)[ ]*/\1:\n-/g' | \
    sed 's/<br>\(.*\)/  \1:/g' | sed 's/\(.*\)<\/p>/  \1:/g' | \
    sed 's/^JSON/    file_format: json/g' | \
    sed 's/^XML/    file_format: xml/g' | \
    sed 's/^Comma/    file_format: csv/g' | \
    sed 's/^Tab/    file_format: tsv/g' | \
    sed 's/^PDF/    file_format: pdf/g' | \
    sed 's/^xlsx/    file_format: xlsx/g'    
