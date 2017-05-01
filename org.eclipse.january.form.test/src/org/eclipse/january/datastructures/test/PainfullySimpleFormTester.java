/*******************************************************************************
 * Copyright (c) 2012, 2016 UT-Battelle, LLC.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Initial API and implementation and/or initial documentation - Jay Jay Billings,
 *   Jordan H. Deyton, Dasha Gorin, Alexander J. McCaskey, Taylor Patterson,
 *   Claire Saunders, Matthew Wang, Anna Wojtowicz
 *******************************************************************************/
package org.eclipse.january.datastructures.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.january.form.DataComponent;
import org.eclipse.january.form.IEntry;
import org.eclipse.january.form.PainfullySimpleForm;
import org.eclipse.january.form.TableComponent;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * The PainfullySimpleFormTester is responsible for testing the
 * PainfullySimpleForm class. It is primarily concerned with checking the
 * ability of the PSF to load itself from a PSF file.
 * </p>
 * 
 * @author Jay Jay Billings
 */
public class PainfullySimpleFormTester {
	/**
	 * 
	 */
	private PainfullySimpleForm painfullySimpleForm;

	/**
	 * <p>
	 * An attribute set up in setupTests and used for loading PSF files.
	 * </p>
	 * 
	 */
	private ArrayList<String> PSFForm;

	/**
	 * <p>
	 * This operation sets up the tests for PainfullySimpleFormTester. Annotated
	 * with @Before clause.
	 * </p>
	 * 
	 */
	@Before
	public void setupTests() {
		PSFForm = new ArrayList<String>();

		// Setup the string containing the Form in PSF format. This was
		// taken from the Painfully Simple Form article at
		// https://sourceforge.net/apps/mediawiki/niceproject/index.php?title=ICE_Painfully_Simple_Form
		// and is a good example because it is complete, contains lots of
		// whitespace and comments and, of course, interesting! I have added
		// whitespaces and comments in some places to make the test more
		// rigorous and changed some of the comment statements from "//" to "#"
		// to cover all the possibilities.
		PSFForm.add("#Add comments here to try to mess the parser up");
		PSFForm.add("\t  \n");
		PSFForm.add("#Form name and type\n");
		PSFForm.add("formName=PSF Wiki Article Form\n");
		PSFForm.add("formDescription=A PSF Wiki Article Sample\n");
		PSFForm.add("formType=Model\n");
		PSFForm.add(" \n");
		PSFForm.add("#The DataComponents block - it must come first!\n");
		PSFForm.add("group=Coolant Group\n");
		PSFForm.add("groupDescription=Data Entries that describe coolant properties\n");
		PSFForm.add("group=Pellet Group\n");
		PSFForm.add("groupDescription=Data Entries that describe the properties of fuel pellets\n");
		PSFForm.add("table=Table Group\n");
		PSFForm.add("tableDescription=I am a Table Group!\n");
		PSFForm.add("\n");
		PSFForm.add("#The Entry blocks will appear below this line");
		PSFForm.add("\n");
		PSFForm.add("\t  \n");
		PSFForm.add("#Some comments to ignore at the top\n");
		PSFForm.add("//More comments to ignore at the top\n");
		PSFForm.add("//And one more\n");
		PSFForm.add("name=Coolant Temperature                        "
				+ "                                #The name that a user "
				+ "will see\n");
		PSFForm.add("description=The temperature of the coolant that surrounds "
				+ "the assembly and pins //A description that will help the user\n");
		PSFForm.add("defaultValue=550                                          "
				+ "                      //The default value\n");
		PSFForm.add("allowedValueType=Continuous                               "
				+ "                      //Indicates that the value can be "
				+ "anything between 550 and 650 K.\n");
		PSFForm.add("allowedValue=550                                          "
				+ "                      //The lower bound of the range\n");
		PSFForm.add("allowedValue=650                                          "
				+ "                      //The upper bound of the range\n");
		PSFForm.add("tag=coolantTemperature                                    "
				+ "                      //A tag to mark it\n");
		PSFForm.add("group=Coolant Group                                       "
				+ "                      //The group\n");
		PSFForm.add("");// An empty line to check it's ability to catch
						// whitespace
		PSFForm.add("//Some Comments to try to confuse the parser\n");
		PSFForm.add("#Some more comments to try to confuse the parser\n");
		PSFForm.add("name=Number of Pins\n");
		PSFForm.add("description=The number of pins in an assembly\n");
		PSFForm.add("defaultValue=289\n");
		PSFForm.add("allowedValueType=Discrete\n");
		PSFForm.add("allowedValue=196\n");
		PSFForm.add("allowedValue=289\n");
		PSFForm.add("tag=numberOfPins\n");
		PSFForm.add("group=Pellet Group\n");
		PSFForm.add("");// An empty line to check it's ability to catch
						// whitespace
		PSFForm.add("#Even more comments\n");
		PSFForm.add("name=Table Entry1\n");
		PSFForm.add("description=A random table entry\n");
		PSFForm.add("defaultValue=289\n");
		PSFForm.add("allowedValueType=Discrete\n");
		PSFForm.add("allowedValue=196\n");
		PSFForm.add("allowedValue=289\n");
		PSFForm.add("tag=tableEntry1\n");
		PSFForm.add("group=Table Group\n");
		PSFForm.add("");// An empty line to check it's ability to catch
						// whitespace
		PSFForm.add("name=Table Entry2\n");
		PSFForm.add("description=Another table entry\n");
		PSFForm.add("defaultValue=9001\n");
		PSFForm.add("allowedValueType=Undefined\n");
		PSFForm.add("tag=tableEntry2\n");
		PSFForm.add("group=Table Group\n");
		// Two lines of whitespace at the end of the text because it should
		// matter whether there are zero or one hundred lines
		PSFForm.add("  \t  \n");
		PSFForm.add("  \t  \n");
		// Add some comments to be mean too!
		PSFForm.add("#Vicious comments here!\n");
		PSFForm.add("#Vicious comments here too!\n");
		PSFForm.add("#Vicious comments here also!\n");

	}

	/**
	 * <p>
	 * This operation checks the PSF by loading it from a string representation
	 * of a PSF (converted to an InputStream).
	 * </p>
	 * 
	 */
	@Test
	public void checkLoadingFromPSF() {
		// Local Declarations
		DataComponent dataComp1 = null, dataComp2 = null;
		TableComponent tableComp = null;
		IEntry entry = null;
		ArrayList<IEntry> tempRowTemplate = null;

		// Print the block for diagnostics
		System.out.println("Dumping PSF Block for Diagnostics:\n" + PSFForm);

		// Create the Form and load it
		painfullySimpleForm = new PainfullySimpleForm();
		try {
			painfullySimpleForm.loadFromPSF(PSFForm);
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}

		// Check the Form in some random spots - FIXME: Use Form.equals() once
		// AJM implements it!
		assertEquals("PSF Wiki Article Form", painfullySimpleForm.getName());
		assertEquals("A PSF Wiki Article Sample",
				painfullySimpleForm.getDescription());
		assertEquals(3, painfullySimpleForm.getNumberOfComponents());
		dataComp1 = (DataComponent) painfullySimpleForm.getComponent(1);
		dataComp2 = (DataComponent) painfullySimpleForm.getComponent(2);
		tableComp = (TableComponent) painfullySimpleForm.getComponents().get(2);
		assertNotNull(dataComp1);
		assertEquals("Coolant Group", dataComp1.getName());
		assertNotNull(dataComp2);
		entry = dataComp2.retrieveAllEntries().get(0);
		assertNotNull(entry);
		assertEquals("289", entry.getDefaultValue());
		assertEquals("numberOfPins", entry.getTag());

		// check for tableComponent
		assertNotNull(tableComp);
		assertEquals("Table Group", tableComp.getName());
		tempRowTemplate = tableComp.getRowTemplate();
		assertNotNull(tempRowTemplate);
		assertEquals(2, tempRowTemplate.size());
		assertEquals("Table Entry1", tempRowTemplate.get(0).getName());
		assertEquals("Table Entry2", tempRowTemplate.get(1).getName());

		return;

	}

	/**
	 * <p>
	 * This operation checks the loadingFromPSFBlock() on PainfullySimpleForm
	 * for a missing Form name. Should throw an IOException.
	 * </p>
	 * 
	 * @throws Class
	 * @throws IOException
	 */
	@Test(expected = java.io.IOException.class)
	public void checkLoadingFromPSFBlockwithMissingFormName()
			throws IOException {
		// Make sure it fails it something isn't correct - in this case a messed
		// up formName statement
		PSFForm.set(3, "PSF Wiki Article Form\n");
		// Create the Form and load it
		painfullySimpleForm = new PainfullySimpleForm();
		// load it up, catch exception
		painfullySimpleForm.loadFromPSF(PSFForm);

	}

	/**
	 * <p>
	 * This operation checks the loadingFromPSFBlock() on PainfullySimpleForm
	 * for an extra group. Should throw an IOException.
	 * </p>
	 * 
	 * @throws Class
	 * @throws IOException
	 */
	@Test(expected = java.io.IOException.class)
	public void checkLoadingFromPSFBlockwithOneExtraGroup() throws IOException {

		// This time try it with an extra group tag
		PSFForm.add(7, "group=Extra Group\n");
		// load and catch exception
		// Create it
		painfullySimpleForm = new PainfullySimpleForm();
		// load and catch IOException
		painfullySimpleForm.loadFromPSF(PSFForm);
	}

	/**
	 * <p>
	 * This operation checks the loadingFromPSFBlock() on PainfullySimpleForm
	 * for a null pointer for lists. Should throw an IOException.
	 * </p>
	 * 
	 * @throws Class
	 * @throws IOException
	 */
	@Test(expected = java.io.IOException.class)
	public void checkLoadingFromPSFBlockwithNullPointer() throws IOException {

		// Try passing null for the input stream
		painfullySimpleForm = new PainfullySimpleForm();
		painfullySimpleForm.loadFromPSF(null);
	}

	/**
	 * <p>
	 * This operation checks the loadingFromPSFBlock() on PainfullySimpleForm
	 * for an entry that references a group that does not exist. Should throw an
	 * IOException.
	 * </p>
	 * 
	 * @throws Class
	 * @throws IOException
	 */
	@Test(expected = java.io.IOException.class)
	public void checkLoadingFromPSFBlockwithEntryUknownGroup()
			throws IOException {
		// Try to put a group name in there that doesn't exist. This is done
		// easiest by overwriting an existing group name.
		// Change the name of one of the good groups
		PSFForm.set(7, "group=Extra Group\n");

		// Create the Form and load it
		painfullySimpleForm = new PainfullySimpleForm();

		// load it
		painfullySimpleForm.loadFromPSF(PSFForm);

	}
}