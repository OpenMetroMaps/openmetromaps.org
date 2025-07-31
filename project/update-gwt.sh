#!/bin/bash

set -e

rm -rf res-nohash/client/demo/

mkdir -p res/client/berlin
cp ../../../OpenMetroMapsData/berlin/geographic.omm res/client/berlin/
cp ../../../OpenMetroMapsData/berlin/schematic.omm res/client/berlin/
cp ../../../OpenMetroMapsData/berlin/nicknames.omm res/client/berlin/

mkdir -p res/client/vienna
cp ../../../OpenMetroMapsData/vienna/geographic.omm res/client/vienna/
cp ../../../OpenMetroMapsData/vienna/schematic.omm res/client/vienna/

mkdir -p res-nohash/client/demo
cp -a ../../OpenMetroMaps/gwt/build/gwt/war/demo/*.cache.js res-nohash/client/demo/
cp -a ../../OpenMetroMaps/gwt/build/gwt/war/demo/clear.cache.gif res-nohash/client/demo/
cp -a ../../OpenMetroMaps/gwt/build/gwt/war/demo/demo.nocache.js res-nohash/client/demo/
