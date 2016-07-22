/*-
 * Copyright 2016 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.january.examples.dataset;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.eclipse.january.dataset.DTypeUtils;
import org.eclipse.january.dataset.Dataset;
import org.slf4j.LoggerFactory;

public class Utils {

	/**
	 * The SLF4J logger produces output when it is not properly configured. For
	 * the purpose of a simple demo, suppress the error message rather than
	 * adding the requirement of a fully configured logger.
	 * <p>
	 * The error message suppressed is:
	 *
	 * <pre>
	 * SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
	 * SLF4J: Defaulting to no-operation (NOP) logger implementation
	 * SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
	 * </pre>
	 */
	public static void suppressSLF4JError() {
		PrintStream saved = System.err;
		try {
			System.setErr(new PrintStream(new OutputStream() {
				public void write(int b) {
				}
			}));
	
			LoggerFactory.getLogger(BasicExample.class);
	
		} finally {
			System.setErr(saved);
		}
	}

	public static void print(Dataset a) {
		print(a.toString(true));
	}

	public static void print(int[] a) {
		print(Arrays.toString(a));
	}

	public static void print(int a) {
		System.out.println(a);
	}

	public static void print(String a) {
		System.out.println(a);
	}

	public static void printDType(Dataset a) {
		System.out.println(DTypeUtils.getDTypeName(a));
	}
}
