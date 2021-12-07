#!/bin/sh

./extract-reporttype-values-yaml.sh > reporttype-values.yaml && \
    yq eval -o=j reporttype-values.yaml | \
    python -c 'import json,sys; print(json.dumps(json.load(sys.stdin), indent=2))' > reporttype-values.json && \
    cat reporttype-values.json | python reporttype-stats.py
