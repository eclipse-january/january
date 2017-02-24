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

# Generate all the template based classes using the Python scripts

python generatefunctions.py functions.txt ../GeneratedMaths.java > GeneratedMaths.java
python fromdouble.py ../../DoubleDataset.java
python fromcpxdouble.py ../../ComplexDoubleDataset.java
python fromcpddouble.py ../../CompoundDoubleDataset.java

for i in *.java
do
  dest=../../$i
  if [[ $i == GeneratedMaths.java ]]; then
    dest=../$i
  fi
  if ! cmp $i $dest > /dev/null; then
    echo "Updating $i"
    mv -f $i $dest
  else
    rm $i
  fi
done

echo "All files are now up to date"
