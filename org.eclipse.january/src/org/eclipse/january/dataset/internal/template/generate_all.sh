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

python3 generatefunctions.py functions.txt MathsPreface.java > Maths.java
python3 fromdouble.py ../../DoubleDataset.java
python3 fromcpxdouble.py ../../ComplexDoubleDataset.java
python3 fromcpddouble.py ../../CompoundDoubleDataset.java

i=Maths.java
dest=../../$i
if ! cmp $i $dest > /dev/null; then
  echo "Updating $i"
  mv -f $i $dest
else
  rm $i
fi

for i in *Dataset*.java
do
  dest=../../$i
  if ! cmp $i $dest > /dev/null; then
    echo "Updating $i"
    mv -f $i $dest
  else
    rm $i
  fi
done

echo "All files are now up to date"
