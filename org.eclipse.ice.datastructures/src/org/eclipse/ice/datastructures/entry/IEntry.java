package org.eclipse.ice.datastructures.entry;

import java.util.List;

import org.eclipse.ice.datastructures.ICEObject.IUpdateable;
import org.eclipse.ice.datastructures.ICEObject.IUpdateableListener;
import org.eclipse.ice.datastructures.ICEObject.Identifiable;

/**
 * 
 * @author aqw
 *
 */
public interface IEntry extends Identifiable, IUpdateable, IUpdateableListener {

	public boolean setValue(String value);
	public boolean setValue(String... value);
	public String getValue();
	public String getValue(int index);
	public String getDefaultValue();
	public void setDefaultValue(String defaultValue);
	public List<String> getAllowedValues();
	public void setAllowedValues(List<String> values);
	public String getComment();
	public void setComment(String comment);
	public String getTag();
	public void setTag(String tag);
	public String getErrorMessage();
	public boolean isReady();
	public boolean isRequired();
	public boolean isModified();
	public void setReady(boolean ready);
	public void setRequired(boolean required);
	public String getContextId();
	public void setContextId(String id);

	
}
