#!/bin/bash

set -e

rm -rf res-nohash/client/demo/

mkdir -p res-nohash/client/berlin
cp ../../../OpenMetroMapsData/berlin/geographic.omm res-nohash/client/berlin/
cp ../../../OpenMetroMapsData/berlin/schematic.omm res-nohash/client/berlin/

mkdir -p res-nohash/client/vienna
cp ../../../OpenMetroMapsData/vienna/geographic.omm res-nohash/client/vienna/
cp ../../../OpenMetroMapsData/vienna/schematic.omm res-nohash/client/vienna/

mkdir -p res-nohash/client/demo
cp -a ../../OpenMetroMaps/gwt/build/gwt/war/demo/*.cache.js res-nohash/client/demo/
cp -a ../../OpenMetroMaps/gwt/build/gwt/war/demo/clear.cache.gif res-nohash/client/demo/
cp -a ../../OpenMetroMaps/gwt/build/gwt/war/demo/demo.nocache.js res-nohash/client/demo/
