#!/bin/bash

if ! command -v java >/dev/null 2>&1 || ! command -v javac >/dev/null 2>&1; then
    echo "Java is not installed. Install Java first."
    exit 1
fi

echo "Java detected 👍"

# Compile
if [ ! -f Main.java ]; then
    echo "Main.java not found."
    exit 1
fi

echo "Compiling..."
javac Main.java

if [ $? -ne 0 ]; then
    echo "Compilation failed."
    exit 1
fi

echo "Running program..."
java Main