#!/bin/bash

mkdir -p generated-sources && thrift --gen py -out generated-sources ../thrift/gen.thrift
