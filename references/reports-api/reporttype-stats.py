from collections import Counter
import json
import sys

data = json.load(sys.stdin)
print("category count:", len(data.keys()))
print("reportType count:", sum([len(v[0]) for v in data.values()]))
print("file_format count:", Counter(sum([[v2['file_format'] if v2 else 'unknown' for k,v2 in v[0].items()] for k,v in data.items()],[])).most_common())
print("reports with unknown file_format: ", sum([[k2 for k2,v2 in v[0].items() if not v2] for k,v in data.items()], []))
