# reportType values analysis tools

Tools to parse [reportype-values.md] file and extract programmer friendly data.

## Prerequisites

Tools installed

* grep
* sed
* yq
* python 3+

## Process

First get stats of `reportype-values.md`

    > ./reporttype-stats.sh
    category count: 16
    reportType count: 101
    total count: 117

Extract YAML from `reportype-values.md` into `reporttype-values.yaml`

    > ./extract-reporttype-values-yaml.sh > reporttype-values.yaml

Extract JSON from `reporttype-values.yaml` into `reporttype-values.json`

    > ./extract-reporttype-values-json.sh

There you get stats of `reportype-values.json`

    > cat reporttype-values.json | python reporttype-stats.py
    category count: 16
    reportType count: 101
    file_format count: [('tsv', 71), ('xml', 14), ('json', 6), ('csv', 5), ('unknown', 2), ('xlsx', 2), ('pdf', 1)]
    reports with unknown file_format:  ['GET_CONVERGED_FLAT_FILE_PENDING_ORDERS_DATA', 'GET_V2_SELLER_PERFORMANCE_REPORT']

and check the results agains the results of `./reporttype-stats.sh`
