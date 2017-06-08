#!/bin/bash

OLD="org.eclipse.jdt.launching.JRE_CONTAINER"
NEW="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/jdk1.8.0_51"

echo "$OLD"
echo "$NEW"

FILES=$(find . -name .classpath)

for f in $FILES; do
	echo $f;
	sed -i -e "s+$OLD+$NEW+" $f
done
