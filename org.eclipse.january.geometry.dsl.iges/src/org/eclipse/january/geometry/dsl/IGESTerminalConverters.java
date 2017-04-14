package org.eclipse.january.geometry.dsl;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractValueConverter;
import org.eclipse.xtext.nodemodel.INode;

import com.google.inject.Inject;

public class IGESTerminalConverters extends DefaultTerminalConverters {

	public static class STRINGValueConverter extends AbstractValueConverter<String> {
		public String toString(String value) {
			return value;
		}

		@Override
		public String toValue(String string, INode node) throws ValueConverterException {
			if (string == null)
				return null;
			try {
				return string;	
			} catch (IllegalArgumentException e) {
				throw new ValueConverterException(e.getMessage(), node, e);
			}
		}
	}
	
	@Inject
	private STRINGValueConverter stringValueConverter;
	
	@ValueConverter(rule = "STRING")
	public IValueConverter<String> STRING() {
		return stringValueConverter;
	}
	
}
