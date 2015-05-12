/*-
 * Copyright 2015 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.api.dataset;

import java.util.Arrays;
import java.util.EventObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Event fired to diseminate information about a dataset changing.
 * For instance if an image represents a live stream.
 * 
 * This event is passed over web-sockets. To keep dependencies to a 
 * minimum and since it is really simple, we have added an encode and
 * decode to JSON without the need for an API like jackson.
 */
public class DataEvent extends EventObject {
	
	private int[]  shape;
	
	/**
	 * Optionally, we can indicate where the file path was.
	 */
	private String filePath;

	/**
	 * The name of the dataset, may be ""
	 */
	private String name;

	public DataEvent() {
		this("", new int[]{1});
	}

	/**
	 * Creates an event to notify that this data has changed.
	 * @param name
	 */
	public DataEvent(String name, int[] shape) {
		super(name);
		this.shape = shape;
		this.name  = name;
	}

	@Override
	public String getSource() {
		return (String)super.getSource();
	}
	
	public String getName() {
		return getSource();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int[] getShape() {
		return shape;
	}

	public void setShape(int[] shape) {
		this.shape = shape;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Encodes event to string
	 * @return encoded string
	 */
	public String encode() {
		final StringBuilder buf = new StringBuilder();
		buf.append("{");
		buf.append("\"name\" : \"");
		buf.append(getName());
		buf.append("\"");
		buf.append(", \"shape\" : ");
		buf.append(Arrays.toString(shape));
		
		buf.append(", \"filepath\" : \"");
		buf.append(getFilePath());
		buf.append("\"");
		
		buf.append("}");
		return buf.toString();
	}
	
	/**
	 * Decodes from String for instance {"name" : "Tests", "shape" : [1024, 1024], "filepath" : "C:/tmp/Fred.txt"}
	 * @return DataEvent
	 */
	public static DataEvent decode(String json) {
		
		String name     = getValue(json, ".*\"name\" \\: \"([^\"]+)\".*");
		String filepath = getValue(json, ".*\"filepath\" \\: \"([^\"]+)\".*");
		String shape    = getValue(json, ".*\"shape\" \\: \\[([^\\]]+)\\].*");

		DataEvent ret = new DataEvent(name, getArray(shape));
		if (filepath!=null && !"null".equals(filepath)) {
			ret.setFilePath(filepath);
		}
		return ret;
	}


	private static String getValue(String json, String regex) {
		Matcher matcher = Pattern.compile(regex).matcher(json);
		if (matcher.matches()) {
			return matcher.group(1);
		}
		throw new RuntimeException(regex+" unmatched in "+json);
	}

	private static int[] getArray(String value) {
		String[] split = value.split(",");
		int[] ret      = new int[split.length];
		for (int i = 0; i < split.length; i++) ret[i] = Integer.parseInt(split[i].trim());
		return ret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(shape);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataEvent other = (DataEvent) obj;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(shape, other.shape))
			return false;
		return true;
	}

}
