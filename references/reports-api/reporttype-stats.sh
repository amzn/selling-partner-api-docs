#!/bin/sh

FILE=reporttype-values.md

CATEGORY_COUNT=`grep -c '^- \[' $FILE`
echo "category count:" $CATEGORY_COUNT

REPORTTYPE_COUNT=`grep -c '<strong>reportType</strong>' $FILE`
echo "reportType count:" $REPORTTYPE_COUNT

echo "total count:" `expr $CATEGORY_COUNT + $REPORTTYPE_COUNT`
