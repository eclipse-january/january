package org.eclipse.ice.datastructures.entry;

import java.net.URI;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * FileEntry is a subclass of the DiscreteEntry that keeps track of 
 * a list of files (as allowed values) for the user to select. The 
 * value for this IEntry is the selected file name. 
 * 
 * @author Alex McCaskey
 *
 */
@XmlRootElement(name = "ExecutableEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExecutableEntry extends DiscreteEntry {

	private URI executableUri;
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ice.datastructures.entry.DiscreteEntry#setValue(java.lang.String)
	 */
	@Override
	public boolean setValue(String newValue) {
		// FIXME MORE TO BE DONE
		return super.setValue(newValue);
	}
	
}
