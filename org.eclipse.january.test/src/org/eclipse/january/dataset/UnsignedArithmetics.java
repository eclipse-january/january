/*-
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.dataset;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Check out arithmetic with unsigned numbers
 * 
 */
public class UnsignedArithmetics {
	final static int MAX = 1 << Byte.SIZE;

	@Test
	public void testAdd() {
		byte[] results = new byte[MAX*MAX];
		int k = 0;
		for (int i = 0; i < MAX; i++) {
			byte bi = (byte) i;
			for (int j = 0; j < MAX; j++) {
				byte bj = (byte) j;
				bj += bi;
				results[k++] = bj;
			}
		}

		k = 0;
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				assertEquals(String.format("%d + %d: ", j, i),  0xff & (j + i), 0xff & results[k++]);
			}
		}
	}

	@Test
	public void testSub() {
		byte[] results = new byte[MAX*MAX];
		int k = 0;
		for (int i = 0; i < MAX; i++) {
			byte bi = (byte) i;
			for (int j = 0; j < MAX; j++) {
				byte bj = (byte) j;
				bj -= bi;
				results[k++] = bj;
			}
		}

		k = 0;
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				assertEquals(String.format("%d - %d: ", j, i),  0xff & (j - i), 0xff & results[k++]);
			}
		}
	}

	@Test
	public void testMul() {
		byte[] results = new byte[MAX*MAX];
		int k = 0;
		for (int i = 0; i < MAX; i++) {
			byte bi = (byte) i;
			for (int j = 0; j < MAX; j++) {
				byte bj = (byte) j;
				bj *= bi;
				results[k++] = bj;
			}
		}

		k = 0;
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				assertEquals(String.format("%d * %d: ", j, i),  0xff & (j * i), 0xff & results[k++]);
			}
		}
	}
	
	@Test
	public void testDiv() {
		byte[] results = new byte[(MAX-1)*MAX];
		int k = 0;
		for (int i = 1; i < MAX; i++) {
			byte bi = (byte) i;
			for (int j = 0; j < MAX; j++) {
				byte bj = (byte) j;
//				bj /= bi;
				results[k++] = divide(bj, bi);
			}
		}

		k = 0;
		for (int i = 1; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				assertEquals(String.format("%d / %d: ", j, i),  0xff & (j / i), 0xff & results[k++]);
			}
		}
	}

	 // unsigned division and remainder
    // Reference: http://www.cise.ufl.edu/~mssz/CompOrg/CDA-arith.html
    public static byte divide(byte num, byte den) {
        if (den == 0) throw new ArithmeticException("/ by zero");
        byte q = num;   // quotient
        byte r = 0;     // remainder
        for (int i = 0; i < 8; i++) {
            r <<= 1;
            if (q < 0) r++;
            q <<= 1;
            if (!lessThan(r, den)) {   // important to do comparison as if they're unsigned
                q++;
                r -= den;
            }
        }
        return q;
    }

    // TODO: comparisons too
	// i < j => (i < j) ^ ((i < 0) != (j < 0))
    public static boolean lessThan(byte x, byte y) {
    	return (x < y) ^ ((x < 0) != (y < 0));
    }

    @Test
    public void testTruncate() {
    	double d = 90458382169.; // this is > 2^31

    	System.err.println("Double is " + d);
    	System.err.println("Long is " + (long) d);
    	System.err.println("Int is " + (int) d);
    	System.err.println("Short is " + (short) d);
    	System.err.println("Byte from double is " + (byte) d);
    	System.err.println("Byte from long is " + (byte) ((long) d));
    	System.err.println("Byte from int is " + (byte) ((int) d));
    	System.err.println("Byte from short is " + (byte) ((short) d));

    }
}
