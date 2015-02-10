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
From complex double dataset generate other classes

$ python fromcpxdouble.py ../ComplexDoubleDataset.java

'''

from markers import transmutate #@UnresolvedImport

# default dataset definition
defds = { "ComplexDoubleDataset":["COMPLEX128", "Double", "double", "getElementDoubleAbs", "toReal(obj)", "%.8g",
"NaN"] }

defkey = defds.keys()[0]

# all other dataset definitions
fds = { "ComplexFloatDataset":["COMPLEX64", "Float", "float", "getElementDoubleAbs", "(float) toReal(obj)", "%.8g",
"NaN"] }

def generateclass(dclass):
    handlers  = [ transmutate(__file__, defkey, defds[defkey], d, fds[d], True) for d in fds ]
    files  = [ open(d + ".java", "w") for d in fds ]
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
        fname = "../ComplexDoubleDataset.java"

    dclass_file = open(fname, 'r')

    generateclass(dclass_file)
