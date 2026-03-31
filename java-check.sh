#!/bin/bash

if command -v java >/dev/null 2>&1 && command -v javac >/dev/null 2>&1; then
    echo "Java is installed"
    java -version
else
    echo "Java is NOT installed"
fi