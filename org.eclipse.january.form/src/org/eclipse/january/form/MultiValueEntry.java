/*******************************************************************************
 * Copyright (c) 2016 UT-Battelle, LLC. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     UT-Battelle, LLC. - initial API and implementation
 *******************************************************************************/
package org.eclipse.january.form;

import java.util.List;

public class MultiValueEntry extends AbstractEntry {

	@Override
	public Object clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setValue(String... values) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getAllowedValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAllowedValues(List<String> values) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(IUpdateable component) {
		// TODO Auto-generated method stub

	}

	@Override
	public String[] getValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(IEntryVisitor visitor) {
		visitor.visit(this);
	}

}
