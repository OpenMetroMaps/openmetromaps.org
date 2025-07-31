# Demo
The Berlin metro system is used as a testing ground for the components developed
for OpenMetroMaps. The examples below feature the work-in-progress maps of
Berlin.

## Web Viewer
Here are links to instances of the
[[JavaScript view|@github(OpenMetroMaps, OpenMetroMaps, #web-viewer)]]:
* [Berlin, schematic](/demo/berlin/schematic)
* [Berlin, geographic](/demo/berlin/geographic)
* [Berlin, nick names](/demo/berlin/nicknames)
* [Vienna, schematic](/demo/vienna/schematic)
* [Vienna, geographic](/demo/vienna/geographic)

## Map Editor
This is a screenshot of the
[[Map Editor|@github(OpenMetroMaps, OpenMetroMaps, #desktop-tools)]],
which is used for creating and editing maps:
<img alt="Map Editor" class="img-responsive" src="images/map-editor.png">

## File Format
One major goal of OpenMetroMaps is to define a file format for storing metro
maps. The current draft is a relatively simple XML-based document.
It has not been formally specified yet, but there are existing files and
running code that reads and writes data in such a format.
Have a look at this example document from the main repository:
[[berlin.omm|@github(OpenMetroMaps, OpenMetroMaps,
/blob/master/java/test-data/src/main/resources/berlin.omm)]]
