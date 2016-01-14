package org.eclipse.ice.datastructures.entry;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ice.datastructures.ICEObject.IUpdateable;

public class DiscreteEntry extends AbstractEntry {

	protected List<String> allowedValues;
	
	public DiscreteEntry() {
		allowedValues = new ArrayList<String>();
	}
	
	@Override
	public Object clone() {
		DiscreteEntry entry = new DiscreteEntry();
		entry.copy(this);
		return entry;
	}

	@Override
	public boolean setValue(String... values) {
		throw new UnsupportedOperationException("Discrete only supports "
				+ "the storage of one String value, not many, selected from "
				+ "a list of allowed values. "
				+ "Therefore, this operation is not supported.");
	}

	@Override
	public boolean setValue(String newValue) {
		if (allowedValues.contains(newValue)) {
			return super.setValue(newValue);
		} 
		return false;
	}

	@Override
	public List<String> getAllowedValues() {
		return allowedValues;
	}

	@Override
	public void setAllowedValues(List<String> values) {
		allowedValues = values;
	}

	@Override
	public void update(IUpdateable component) {
		// Do nothing
	}

}
