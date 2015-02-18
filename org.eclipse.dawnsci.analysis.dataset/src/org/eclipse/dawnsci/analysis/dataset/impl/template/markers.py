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
transmutation class for markers

It performs line-by-line substitutions based on markers embedded in comments.

Mark up source class with following comment markers:
// DATA_TYPE      - dataset constant
// CLASS_TYPE     - boxed primitive class
// PRIM_TYPE      - java primitive type
// PRIM_TYPE_LONG - java primitive type (cast to long first if integer)
// GET_ELEMENT    - use get element method
// FROM_OBJECT    - use convert from object method
// REAL_ONLY      - keep line when a real dataset
// OBJECT_UNEQUAL - use object inequality
// OBJECT_USE     - use commented out code
// BOOLEAN_OMIT   - omit line when boolean dataset
// BOOLEAN_USE    - use commented out code
// BOOLEAN_FALSE  - return false when boolean dataset
// BOOLEAN_ZERO   - return zero when boolean dataset
// NAN_OMIT       - omit line when not a numerical dataset
// FORMAT_STRING  - format string for getString method
// DEFAULT_VAL    - default value for expanded dataset
// INT_EXCEPTION  - surround with try/catch for integer arithmetic exception
// INT_ZEROTEST   - use commented out code for testing for integer zero
// ADD_CAST       - add a cast to primitive type
// OMIT_SAME_CAST - omit a cast to same type 
// OMIT_REAL_CAST - omit a cast to real type 
// OMIT_CAST_INT  - omit a cast for int type 
// OMIT_UPCAST    - omit a cast to same type 
// IGNORE_CLASS   - ignored dataset class used in line
// GEN_COMMENT    - replace this with a message about generated class
@SuppressWarnings("cast")
'''

class transmutate(object):
    def __init__(self, scriptfile, srcclass, source, dstclass, destination, disreal=True,
                 disbool=False, disobj=False, isatomic=True):
        '''
        scriptfile
        srcclass
        source
        dstclass
        destination
        disreal indicates whether destination is a real dataset
        disbool indicates whether destination is a boolean dataset
        disobj indicates whether destination is an object type-dataset
        isatomic indicates whether dataset is atomic or compound

        source and destination are lists of strings which describe dtype,
        Java boxed primitive class, Java primitive type, getElement abstract method,
        Object converter toReal, string format, default expansion value
        (from class constant)
        '''
        self.sdsclass = srcclass
        self.ddsclass = dstclass
        self.commentline = "// This is generated from %s.java by %s" % (srcclass, scriptfile)

        if len(source) != len(destination):
            raise ValueError, "length of lists should be the same"

        (self.sdtype, self.spclass, self.sprim, self.sgetel,
        self.sconv, self.sform, self.sdef) = source
        (self.ddtype, self.dpclass, self.dprim, self.dgetel,
        self.dconv, self.dform, self.ddef) = destination

        self.dcast = "(" + self.dprim + ") "
        self.Sprim = self.sprim.capitalize()
        self.Dprim = self.dprim.capitalize()

        if (self.ddtype.startswith("INT") or self.ddtype.startswith("ARRAYINT")) and self.dprim is not "long":
            self.dprimlong = self.dcast + "(long) "
        else:
            self.dprimlong = self.dcast

        self.isreal = disreal
        self.isbool = disbool
        self.isobj = disobj
        self.isatomic = isatomic
        if self.isbool:
            self.isreal = False
        if not self.isatomic: # make compound dataset types
            self.scdtype = "ARRAY" + self.sdtype
            self.dcdtype = "ARRAY" + self.ddtype

        processors = [("// DATA_TYPE", self.data),
            ("// CLASS_TYPE", self.jpclass),
            ("// PRIM_TYPE", self.primitive),
            ("// ADD_CAST", self.addcast),
            ("// PRIM_TYPE_LONG", self.primitivelong),
            ("// GET_ELEMENT", self.getelement),
            ("// GET_ELEMENT_WITH_CAST", self.getelementcast),
            ("// FROM_OBJECT", self.fromobj),
            ("// REAL_ONLY", self.unrealomit),
            ("// OBJECT_UNEQUAL", self.unequal),
            ("// OBJECT_USE", self.objuse),
            ("// BOOLEAN_OMIT", self.boolomit),
            ("// BOOLEAN_USE", self.booluse),
            ("// BOOLEAN_FALSE", self.boolfalse),
            ("// BOOLEAN_ZERO", self.boolzero),
            ("// NAN_OMIT", self.nanomit),
            ("// FORMAT_STRING", self.string),
            ("// INT_OMIT", self.intomit),
            ("// INT_USE", self.intuse),
            ("// INT_EXCEPTION", self.intexception),
            ("// INT_ZEROTEST", self.intzerotest),
            ("// OMIT_SAME_CAST", self.omitcast),
            ("// OMIT_REAL_CAST", self.omitrealcast),
            ("// OMIT_CAST_INT", self.omitcastint),
            ("// OMIT_UPCAST", self.omitupcast),
            ("// DEFAULT_VAL", self.defval),
            ("@SuppressWarnings(\"cast\")", self.omit),
            (srcclass, self.jclass)]

        self.icasts = [ "(byte) ", "(short) ", "(int) ", "(long) "]
        self.rcasts = [ "(float) ", "(double) "]

        # also // IGNORE_CLASS
#        print "prim |", self.dprim, "| conv |", self.dconv, "| cast |", self.dcast
#        if self.dprim in self.dconv:
#            print 'found primitive matches cast'

        self.plist = [t[0] for t in processors]
        self.processors = dict(processors)

    # Java identifier
    # starts with _, $ and unicode letter and comprises Unicode letters and digits
    import re
    separator = re.compile(r'[\s(]')

    def data(self, line):
        '''
        dataset type
        '''
        l = line.replace(self.sdtype, self.ddtype)
        if not self.isatomic:
            l = l.replace(self.scdtype, self.dcdtype)
        return l

    def jclass(self, line):
        '''
        dataset name is also used as Java class name
        '''
        return line.replace(self.sdsclass, self.ddsclass)

    def jpclass(self, line):
        '''
        Java class name for boxed primitive
        '''
        if self.isobj and 'valueOf' in line:
            l = line.replace(self.spclass, '')
            l = l.replace('.valueOf(', '')
            l = l.replace(');', ';')
            return l
        return line.replace(self.spclass, self.dpclass)

    def primitive(self, line):
        '''
        java primitive type is an element type
        '''
        if line.find(self.sprim) >= 0:
            return line.replace(self.sprim, self.dprim)
        if line.find(self.Sprim) >= 0:
            return line.replace(self.Sprim, self.Dprim)
        return line

    def primitivelong(self, line):
        return line.replace(self.dcast, self.dprimlong)

    def getelement(self, line):
        return line.replace(self.sgetel, self.dgetel)

    def getelementcast(self, line):
        l = line.replace(self.sgetel, self.dgetel)
        if not self.isobj and self.dprim in self.dconv:
            l = self.addcastmethod(l, self.dgetel)
        return l

    def addcast(self, line):
        l = line
        for t in [' = ', ' += ', ' -= ', ' *= ', ' /= ', ' %= ']:
            l = l.replace(t, t + self.dcast)
        return l

#    t.rfind(separator.split(t)[-1]
    
    def addcastmethod(self, line, method):
        # find first part of identifier
        bits = line.split(method)
        prefix = bits[0][:-1] # miss out dot
        l = transmutate.separator.split(prefix)
        pind = prefix.rfind(l[-1])
        if pind < 0:
            raise ValueError, 'Cannot find an identifier'
        return ''.join(prefix[:pind]) + self.dcast + ''.join(prefix[pind:]) + '.' + method + ''.join(bits[1:])

    def fromobj(self, line):
#        if self.isobj or self.dconv is None:
#            l = line.replace(self.sconv, '')
#            return l
        return line.replace(self.sconv, self.dconv)

    def omitcast(self, line):
        return line.replace(self.dcast, "")

    def omitcastint(self, line):
        if self.isreal or self.isbool:
            return line
        for c in self.icasts:
            if c in line:
                return line.replace(c, "")
        return line

    def omitrealcast(self, line):
#        if self.isreal:
#            return line
        for c in self.rcasts:
            if c in line:
                return line.replace(c, "")
        return line

    def omitupcast(self, line):
        if self.isreal or self.isbool:
            return line
        f = False
        for c in self.icasts:
#            print line, c, f
            if c == self.dcast:
                f = True
            if f and c in line:
                return line.replace(c, "")
        return line

    def omit(self, line):
        return None

    def unrealomit(self, line):
        if not self.isreal:
            return None
        return line

    def unequal(self, line):
        if not self.isobj:
            return line
        l = line.replace(' != ', '.equals(')
        l = l.replace('if (', 'if (!')
        return l.replace(') ', ')) ')

    def objuse(self, line):
        if self.isobj: # uncomment line
            s = line.find("// ")
            return line[:s] + line[s+3:]
        return line

    def boolomit(self, line):
        if self.isbool:
            return None
        return line.replace(" // BOOLEAN_OMIT", "")

    def booluse(self, line):
        if self.isbool: # uncomment line
            s = line.find("// ")
            return line[:s] + line[s+3:]
        return line

    def boolfalse(self, line):
        if self.isbool or self.isobj:
            return "\t\treturn false;"
        return line

    def boolzero(self, line):
        if self.isbool or self.isobj:
            return "\t\treturn 0;"
        return line

    def nanomit(self, line):
        if self.isobj or self.isbool:
            return None
        return line.replace(" // NAN_OMIT", "")

    def string(self, line):
        if self.isobj and 'String' == self.dpclass:
            s = line.find(self.sform)
            b = line.find("String")
            e = line.find(';', s)
            if e < 0:
                e = line.find(' :', s)
            return line[:b] + line[s+len(self.sform) + 2:(e-1)] + line[e:]
        return line.replace(self.sform, self.dform)

    def intomit(self, line):
        if not self.isreal:
            return None
        return line.replace(" // INT_OMIT", "")

    def intuse(self, line):
        if not self.isreal: # uncomment line
            s = line.find("// ")
            return line[:s] + line[s+3:]
        return line

    def intexception(self, line):
        if self.ddtype.startswith("INT"):
            nformat = "\t\t\t\ttry {\n\t%s\n\t\t\t\t} catch (ArithmeticException e) {\n\t\t\t\t\t%s] = 0;\n\t\t\t\t}"
            lhs = line.split('] ')[0].lstrip()
            return nformat % (line, lhs)
        elif self.ddtype.startswith("ARRAYINT"):
            nformat = "\t\t\t\t\t\ttry {\n\t%s\n\t\t\t\t\t\t} catch (ArithmeticException e) {\n\t\t\t\t\t\t\t%s] = 0;\n\t\t\t\t\t\t}"
            lhs = line.split('] ')[0].lstrip()
            return nformat % (line, lhs)
        else:
            return line

    def intzerotest(self, line):
        if self.ddtype.startswith("INT") or self.ddtype.startswith("ARRAYINT"):
            s = line.find("// ")
            return line[:s] + line[s+3:]
        else:
            return line

    def defval(self, line):
        if self.isobj:
            return None
        return line.replace(self.sdef, self.ddef)

    def processline(self, line):
        '''
        return processed line
        '''
        l = line.rstrip()
        if l.find("// IGNORE_CLASS") >= 0:
            return l
        for m in self.plist:
            if l == None or len(l) == 0:
                break
            if l.find(m) >= 0:
                p = self.processors[m]
                l = p(l)
        if l != None:
            if l.find("// GEN_COMMENT") >= 0:
                return self.commentline
        return l
