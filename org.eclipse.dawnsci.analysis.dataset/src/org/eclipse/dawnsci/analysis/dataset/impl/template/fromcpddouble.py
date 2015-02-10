###
# *******************************************************************************
# * Copyright (c) 2011, 2014 Diamond Light Source Ltd.
# * All rights reserved. This program and the accompanying materials
# * are made available under the terms of the Eclipse Public License v1.0
# * which accompanies this distribution, and is available at
# * http://www.eclipse.org/legal/epl-v10.html
# *
# * Contributors:
# *    Peter Chang - initial API and implementation and/or initial documentation
# *******************************************************************************/
###

#!/usr/bin/env python
'''
From compound double dataset generate other classes

$ python fromcpddouble.py ../CompoundDoubleDataset.java

'''

from markers import transmutate #@UnresolvedImport

# default dataset definition
defds = { "CompoundDoubleDataset":["FLOAT64", "Double", "double", "getElementDoubleAbs", "toReal(obj)", "%.8g",
"NaN"] }

defkey = defds.keys()[0]

# all other dataset definitions
fds = { "CompoundFloatDataset":["FLOAT32", "Float", "float", "getElementDoubleAbs", "(float) toReal(obj)", "%.8g",
"NaN"] }

allds = { 
"CompoundIntegerDataset":["INT32", "Integer", "int", "getElementLongAbs", "(int) toLong(obj)", "%d",
"MIN_VALUE"],
"CompoundLongDataset":["INT64", "Long", "long", "getElementLongAbs", "toLong(obj)", "%d",
"MIN_VALUE"],
"CompoundShortDataset":["INT16", "Short", "short", "getElementLongAbs", "(short) toLong(obj)", "%d",
"MIN_VALUE"],
"CompoundByteDataset":["INT8", "Byte", "byte", "getElementLongAbs", "(byte) toLong(obj)", "%d",
"MIN_VALUE"]
 }

def generateclass(dclass):
    handlers  = [ transmutate(__file__, defkey, defds[defkey], d, fds[d], True, isatomic=False) for d in fds ]
    handlers += [ transmutate(__file__, defkey, defds[defkey], d, allds[d], False, isatomic=False) for d in allds ]
    files  = [ open(d + ".java", "w") for d in fds ]
    files += [ open(d + ".java", "w") for d in allds ]
    ncls = len(files)

    while True:
        l = dclass.readline()
        if not l:
            break
        for n in range(ncls):
            nl = handlers[n].processline(l)
            if nl != None:
                print >> files[n], nl

if __name__ == '__main__':
    import sys
    if len(sys.argv) > 1:
        fname = sys.argv[1]
    else:
        fname = "../CompoundDoubleDataset.java"

    dclass_file = open(fname, 'r')

    generateclass(dclass_file)
