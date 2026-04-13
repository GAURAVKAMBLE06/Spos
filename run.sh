#!/usr/bin/env bash
set -euo pipefail

javac -d out src/com/spos/weatherims/*.java
java -cp out com.spos.weatherims.Main
