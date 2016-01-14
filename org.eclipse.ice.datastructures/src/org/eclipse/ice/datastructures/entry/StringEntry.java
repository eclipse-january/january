package org.eclipse.ice.datastructures.entry;

import java.util.List;

import org.eclipse.ice.datastructures.ICEObject.IUpdateable;

public class StringEntry extends AbstractEntry {

	@Override
	public Object clone() {
		StringEntry entry = new StringEntry();
		
		entry.copy(this);
		
		return entry;
	}

	@Override
	public boolean setValue(String... values) {
		throw new UnsupportedOperationException("StringEntry only supports "
				+ "the storage of one String value, not many. "
				+ "Therefore, this operation is not supported.");
	}

	@Override
	public List<String> getAllowedValues() {
		throw new UnsupportedOperationException("StringEntry allows any String to "
				+ "be entered as the value. There are no allowed values. Therefore this "
				+ "operation is not supported.");
	}

	@Override
	public void setAllowedValues(List<String> values) {
		throw new UnsupportedOperationException("StringEntry allows any String to "
				+ "be entered as the value. There are no allowed values. Therefore this "
				+ "operation is not supported.");

	}

	@Override
	public void update(IUpdateable component) {
		// do nothing
	}

}
