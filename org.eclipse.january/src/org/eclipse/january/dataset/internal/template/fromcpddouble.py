#!/usr/bin/env python
###
# *******************************************************************************
# * Copyright (c) 2011, 2017 Diamond Light Source Ltd.
# * All rights reserved. This program and the accompanying materials
# * are made available under the terms of the Eclipse Public License v1.0
# * which accompanies this distribution, and is available at
# * http://www.eclipse.org/legal/epl-v10.html
# *
# * Contributors:
# *    Peter Chang - initial API and implementation and/or initial documentation
# *******************************************************************************/
###

'''
From compound double dataset generate other classes

$ python fromcpddouble.py ../../CompoundDoubleDataset.java

'''

from __future__ import print_function

from markers import transmutate #@UnresolvedImport

# default dataset definition
defds = { "CompoundDoubleDataset":["FLOAT64", "Double", "double", "getElementDoubleAbs", "DTypeUtils.toReal(obj)", "%.8g",
"NaN"] }

defkey = list(defds.keys())[0]

# all other dataset definitions
fds = { "CompoundFloatDataset":["FLOAT32", "Float", "float", "getElementDoubleAbs", "(float) DTypeUtils.toReal(obj)", "%.8g",
"NaN"] }

allds = {
"CompoundIntegerDataset":["INT32", "Integer", "int", "getElementLongAbs", "(int) DTypeUtils.toLong(obj)", "%d",
"MIN_VALUE"],
"CompoundLongDataset":["INT64", "Long", "long", "getElementLongAbs", "DTypeUtils.toLong(obj)", "%d",
"MIN_VALUE"],
"CompoundShortDataset":["INT16", "Short", "short", "getElementLongAbs", "(short) DTypeUtils.toLong(obj)", "%d",
"MIN_VALUE"],
"CompoundByteDataset":["INT8", "Byte", "byte", "getElementLongAbs", "(byte) DTypeUtils.toLong(obj)", "%d",
"MIN_VALUE"]
 }

def generateclass(dclass):
    handlers  = [ transmutate(__file__, defkey, defds[defkey], d, fds[d], True) for d in fds ]
    handlers += [ transmutate(__file__, defkey, defds[defkey], d, allds[d], False) for d in allds ]
    files  = [ open(d + ".java", "w") for d in fds ]
    files += [ open(d + ".java", "w") for d in allds ]

    while True:
        l = dclass.readline()
        if not l:
            break
        for h,f in zip(handlers, files):
            nl = h.processline(l)
            if nl != None:
                print(nl, file=f)

if __name__ == '__main__':
    import sys
    if len(sys.argv) > 1:
        fname = sys.argv[1]
    else:
        fname = "../../CompoundDoubleDataset.java"

    dclass_file = open(fname, 'r')

    generateclass(dclass_file)
