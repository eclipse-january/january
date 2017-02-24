#!/bin/bash
###
# *******************************************************************************
# * Copyright (c) 2017 Kichwa Coders Ltd.
# * All rights reserved. This program and the accompanying materials
# * are made available under the terms of the Eclipse Public License v1.0
# * which accompanies this distribution, and is available at
# * http://www.eclipse.org/legal/epl-v10.html
# *
# * Contributors:
# *    Jonah Graham - initial API and implementation and/or initial documentation
# *******************************************************************************/
###

# Verify all the template based classes using the Python scripts

python generatefunctions.py functions.txt ../GeneratedMaths.java > GeneratedMaths.java
python fromdouble.py ../../DoubleDataset.java
python fromcpxdouble.py ../../ComplexDoubleDataset.java
python fromcpddouble.py ../../CompoundDoubleDataset.java

differences_found=false
for i in *.java
do
  orig=../../$i
  if [[ $i == GeneratedMaths.java ]]; then
    orig=../$i
  fi
  if ! cmp $i $orig; then
    differences_found=true
    echo "Differences found for $i -- it needs to be regenerated"
    diff -u $i $orig
  fi
  rm $i
done

if [[ $differences_found == true ]]; then
  echo "Build aborted as there are files that need to be re-generated"
  exit 1
else
  echo "All generated files are up to date"
  exit 0
fi
