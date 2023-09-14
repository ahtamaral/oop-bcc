#!/bin/bash

# Create the classes directory if it doesn't exist
mkdir -p classes

# Compile Java source files and generate .class files
find src -name "*.java" > sources.txt
if javac -d classes @sources.txt; then
    echo "Compilation successful!"
    rm sources.txt

    # Create the binary
    jar cvfe app.jar Principal -C classes .

    # Clean up temporary class files
    rm -r classes

    echo "Binary creation complete!"
else
    echo "Compilation failed. No binary generated."
    rm sources.txt
    rm -r classes
fi
