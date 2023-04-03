#!/bin/bash

for ((i = 21 ; i>=0 ; i--))
do
	curl -v -X POST http://localhost:8080/api/v1/area/rectangle \       
    -H "Content-Type: application/json" \
    -d '{ "length": 10, "breadth": 12 }'

done

