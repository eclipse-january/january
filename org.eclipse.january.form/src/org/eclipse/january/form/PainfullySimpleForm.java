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
package org.eclipse.january.form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * The PainfullySimpleForm is a Form that is initialized from a InputStream that
 * contains the serialized contents of a Form in <a href=
 * "https://sourceforge.net/apps/mediawiki/niceproject/index.php?title=ICE_Painfully_Simple_Form#The_Painfully_Simple_Form_File_Format"
 * rel="">the Painfully Simple Form file format (PSF)</a>. A description of the
 * file format may also be found in the internal January documentation. The
 * Painfully Simple Form does not maintain any memory of the stream from which
 * it created itself.
 * </p>
 * 
 * @author Jay Jay Billings
 */
@XmlRootElement(name = "Form")
public class PainfullySimpleForm extends Form {
	/**
	 * <p>
	 * An attribute that holds an arraylist of entries with a key relative to
	 * the TableComponent's name. This is setup in the loadEntries operation.
	 * </p>
	 */
	private HashMap<String, ArrayList<IEntry>> rowTemplates;

	/**
	 * Reference to the current Entry's group
	 */
	private String currentGroup;

	/**
	 * <p>
	 * The constructor.
	 * </p>
	 * 
	 */
	public PainfullySimpleForm() {

		// Call the super constructor
		super();

		// prepare rowTemplates
		this.rowTemplates = new HashMap<String, ArrayList<IEntry>>();

	}

	/**
	 * <p>
	 * This operation loads the PainfullySimpleForm from an set of strings that
	 * contains the contents of the Form in the Painfully Simple Form file
	 * format. Each string in the set should be a separate line from the PSF
	 * file. If it is unable to load the properties in the strings or determines
	 * that the contents of the strings are not consistent with the PSF format,
	 * then it will throw an IOException. Although it seems strange to throw an
	 * IOException when reading through an array of strings, the assumption here
	 * is that the strings came directly from a file and that the work to parse
	 * it has been delegated to the PSF, which means that it is its duty to
	 * throw the error.
	 * </p>
	 * 
	 * @param inputLines
	 *            <p>
	 *            The lines of the PSF file as a set of strings with each string
	 *            being a different line.
	 *            </p>
	 * @throws IOException
	 */
	public void loadFromPSF(ArrayList<String> inputLines) throws IOException {

		// Local Declarations
		int firstEntryLine = 0;
		ArrayList<String> emptyLines = new ArrayList<String>();
		ArrayList<String> formAndGroupLines = new ArrayList<String>();
		ArrayList<String> entryLines = new ArrayList<String>();

		// This will only work if the stream is not null
		if (inputLines != null) {
			// Segregate the lines
			for (String currentLine : inputLines) {
				// Get the group lines and make sure it has an "=" character in
				// it!
				if (currentLine.startsWith("group=")
						|| currentLine.startsWith("table=")
						|| currentLine.startsWith("groupDescription=")
						|| currentLine.startsWith("tableDescription=")
						|| currentLine.startsWith("formName=")
						|| currentLine.startsWith("formDescription=")
						|| currentLine.startsWith("formType=")) {
					formAndGroupLines.add(currentLine);
				}
				// Skip over comments, empty lines and erroneous data lines
				// without the equals sign
				else if (currentLine.matches("^$|(?m)^\\s+$")
						|| currentLine.startsWith("#")
						|| currentLine.startsWith("//")
						|| !currentLine.contains("=")) {
					continue;
				} else {
					// Else if it is not one of the previous tags, whitespace or
					// a comment then it must be a line from an Entry block. Get
					// the index and break.
					firstEntryLine = inputLines.indexOf(currentLine);
					break;
				}
			}
			// Make sure it is a PSF stream, fail if not
			if (!isPSF(formAndGroupLines)) {
				throw new IOException("This is not a PSF InputStream! "
						+ "Check the blocks and make sure they are in the "
						+ "proper order!");
			}
			// Set the Form name
			setName(formAndGroupLines.get(0).split("=")[1].trim());
			setDescription(formAndGroupLines.get(1).split("=")[1].trim());
			// Load the DataComponents
			loadComponents(formAndGroupLines);
			// Load the Entries by getting the subset of the lines
			loadEntries(new ArrayList<String>(inputLines.subList(
					firstEntryLine, inputLines.size())));
			// sets up the rowTemplates into the tableComponents
			setupRowTemplates();

		} else {
			throw new IOException("PSF InputStream cannot be null!");
		}
		return;
	}

	/**
	 * <p>
	 * This operation checks the InputStream to determine if it is in the
	 * Painfully Simple Form file format.
	 * </p>
	 * 
	 * @param lines
	 *            <p>
	 *            The lines from the PSF stream.
	 *            </p>
	 * @return <p>
	 *         True if the format matches the PSF, false otherwise.
	 *         </p>
	 */
	private boolean isPSF(ArrayList<String> lines) {

		// Local Declarations
		boolean retFlag = false;

		// The first tag should be the Form name
		if (lines.get(0).contains("=")) {
			retFlag = (("formName").equals((lines.get(0).split("="))[0])
			// The third tag should be a group name
			&& ("group".equals((lines.get(3).split("="))[0])
			// The fourth tag should be a groupDescription
			&& ("groupDescription".equals((lines.get(4).split("="))[0]))));
		}

		return retFlag;
	}

	/**
	 * <p>
	 * This operation loads the DataComponents and sets up the rowTemplates in
	 * the PSF stream into the Form.
	 * </p>
	 * 
	 * @param lines
	 *            <p>
	 *            The lines of text from the PSF file.
	 *            </p>
	 * @throws IOException
	 */
	private void loadComponents(ArrayList<String> lines) throws IOException {

		// Local Declarations
		String[] splitLines = { "", "" };
		ArrayList<String> groups = new ArrayList<String>();
		ArrayList<String> groupDescriptions = new ArrayList<String>();
		ArrayList<String> tables = new ArrayList<String>();
		ArrayList<String> tableDescriptions = new ArrayList<String>();
		int idCount = 0;
		int i;

		DataComponent dataComp = null;
		TableComponent tableComp = null;
		// A flag that is marked when the block of group text is hit. This flag
		// is checked during the parse to make sure that the we haven't run into
		// the Entry blocks.
		boolean hitGroupsBlock = false;

		// Loop over the lines and load the components. This loop assumes that
		// group descriptions are always after group tags, which is part of the
		// spec!
		for (i = 3; i < lines.size(); i++) {
			String currentLine = lines.get(i);
			splitLines = currentLine.split("=");
			// If it is a new "group" line, add it to the appropriate list
			if (currentLine.startsWith("group=")) {
				groups.add(splitLines[1].trim());
				// Set a flag so that we know that we are now in the groups
				// block
				hitGroupsBlock = true;
			}
			if (currentLine.startsWith("table=")) {
				tables.add(splitLines[1].trim());
				// Set a flag so that we know that we are now in the groups
				// block
				hitGroupsBlock = true;
			} else if (currentLine.startsWith("groupDescription=")) {
				// Add a group description line to the appropriate list
				groupDescriptions.add(splitLines[1].trim());
			} else if (currentLine.startsWith("tableDescription=")) {
				// Add a group description line to the appropriate list
				tableDescriptions.add(splitLines[1].trim());
			} else if (currentLine.matches("^$|(?m)^\\s+$") && hitGroupsBlock) {
				// Break out of the loop if we hit an empty line after we hit
				// the groups block
				break;
			}
		}

		// Make sure that for each group there is a group description. If not,
		// the file does not satisfy the specification and an exception should
		// be thrown.
		if (!(groups.size() == groupDescriptions.size())) {
			throw new IOException("This file does not appear to contain a "
					+ "group description for each of its groups and thereby "
					+ "violates the PSF specification. Please check your file!");
		}
		// Create the DataComponents
		for (i = 0; i < groups.size(); i++) {
			// Add a DataComponent
			dataComp = new DataComponent();
			dataComp.setId(i + 1); // i + 1 so that no ids are zero
			dataComp.setName(groups.get(i));
			dataComp.setDescription(groupDescriptions.get(i));
			addComponent(dataComp);
		}

		// Create the TableComponents
		for (i = 0; i < tables.size(); i++) {
			// Add a TableComponent
			tableComp = new TableComponent();
			tableComp.setId(groups.size() + i + 1); // i + 1 so that no ids are
													// zero
			tableComp.setName(tables.get(i));
			tableComp.setDescription(tableDescriptions.get(i));
			addComponent(tableComp);

			// Prepare the rowTemplates
			rowTemplates.put(tableComp.getName(), new ArrayList<IEntry>());
		}

		return;

	}

	/**
	 * <p>
	 * This operations loads the Entries in the PSF stream into the
	 * DataComponents of the Form.
	 * </p>
	 * 
	 * @param lines
	 *            <p>
	 *            The lines of text from the PSF file.
	 *            </p>
	 * @throws IOException
	 */
	private void loadEntries(ArrayList<String> lines) throws IOException {

		// Local Declarations
		int lowerBound = 0, upperBound = 0; // Loop variables for tracking block
											// boundaries
		// A map of the component names to the component ids
		ArrayList<Integer> emptyLines = new ArrayList<Integer>();
		HashMap<String, Integer> componentMap = new HashMap<String, Integer>();
		JanuaryObject compRef = null;
		TableComponent tableRef = null;
		DataComponent dataRef = null;

		// Temp list for TableEntries
		Integer tableCount = 0;
		ArrayList<IEntry> tempArray = null;

//		PainfullySimpleEntry entry = null;
		IEntry entry = null;

		boolean lastLineEmpty = false;

		// Setup the component map
		for (Component i : this.getComponents()) {
			compRef = (JanuaryObject) i;
			componentMap.put(compRef.getName(), compRef.getId());
		}

		// Check the last line. If it is empty, then continue, but if it is not
		// empty then add an empty line
		if (!lines.get(lines.size() - 1).matches("^$|(?m)^\\s+$")) {
			lines.add("\t \n");
		}
		// Get the block numbers
		for (int i = 0; i < lines.size(); i++) {
			String currentLine = lines.get(i);
			// Identify an empty line and add it to the list. Empty lines only -
			// not comments! Also make sure that there are not two empty lines
			// next to each other, which the parser shouldn't care about.
			if (currentLine.matches("^$|(?m)^\\s+$") && !lastLineEmpty) {
				emptyLines.add(i);
				lastLineEmpty = true;
			} else if (currentLine.startsWith("//")
					|| currentLine.startsWith("#")) {
				lastLineEmpty = true;
			} else {
				lastLineEmpty = false;
			}

		}

		// Create the Entries - start with the first empty line because this
		// function will always be called with a list that starts with a "name"
		// statement.
		lowerBound = 0;
		upperBound = emptyLines.get(0);
		for (int i = 0; i < emptyLines.size(); i++) {

			// Create the Entry
//			entry = new PainfullySimpleEntry();
			// Load from an ArrayList of the PSF block created as a sublist.
			ArrayList<String> lineList = new ArrayList<String>(lines.subList(lowerBound, upperBound +1));
			
			entry = loadFromPSFBlock(new ArrayList<String>(lines.subList(
					lowerBound, upperBound + 1)));
			
			// Set the id
			entry.setId(i + 1);
			// Make sure the group is valid and throw an exception if not
			if (componentMap.containsKey(currentGroup)) {

				// Get the Component and add the Entry
				compRef = (JanuaryObject) getComponent(componentMap.get(currentGroup));
				// Case handle for DataComponent or TableComponent

				// If TableComponent, add entry to a temp list
				if (rowTemplates.containsKey(currentGroup)) {
					// If the group exists, add to the array
					tempArray = rowTemplates.get(currentGroup);
					tempArray.add(entry);
				} else {
					dataRef = (DataComponent) compRef;
					dataRef.addEntry(entry);
				}

				// Update the lowerbound
				lowerBound = upperBound;
				// Determine the correct upper bound for the next loop
				upperBound = (upperBound == emptyLines
						.get(emptyLines.size() - 1) || upperBound == lines
						.size()) ? lines.size() : emptyLines.get(i + 1);
			} else {
				throw new IOException("Entry " + entry.getName()
						+ " has an invalid group! Group = " + currentGroup);
			}

		}

		// finished!
		return;

	}

	/**
	 * Create a new IEntry from the given lines of text. 
	 * 
	 * @param inputStrings
	 * @return
	 * @throws IOException
	 */
	private IEntry loadFromPSFBlock(ArrayList<String> inputStrings) throws IOException {

		// Local Declarations
		ArrayList<String> linesToRemove = new ArrayList<String>();
		String[] splitStrings = { "", "" };
		ArrayList<String> validKeys = new ArrayList<String>();
		IEntry retEntry = null;
		String name = "", description = "", tag = "", defaultValue = "", valueType = "";
		ArrayList<String> allowed = new ArrayList<String>();
		
		// This will only work if the string is not null
		if (inputStrings != null) {
			// Setup the list of valid keys
			validKeys.add("name");
			validKeys.add("description");
			validKeys.add("defaultValue");
			validKeys.add("allowedValueType");
			validKeys.add("allowedValue");
			validKeys.add("tag");
//			validKeys.add("parent");
			validKeys.add("group");
			// Loop over all of the strings and parse the data
			for (String currentString : inputStrings) {
				// Search for any lines that are whitespace are comments
				if (currentString.matches("^$|(?m)^\\s+$") || // Whitespace
						currentString.startsWith("#") || // Comments with #
						currentString.startsWith("//")) { // Comments with //
					continue;
				}
				// Search for comments at the end of the line and remove them
				if (currentString.contains("#")) {
					currentString = currentString.replaceAll("\\#.*", "");
				} else if (currentString.contains("//")) {
					currentString = currentString.replaceAll("\\/\\/.*", "");
				}
				// Make sure the string contains an equal sign or throw an
				// exception
				if (!currentString.contains("=")) {
					throw new IOException(
							"String in Entry block does not contain an " + "equals sign! The string was at line "
									+ inputStrings.indexOf(currentString) + ":\n" + currentString);
				}
				// Trim and split the string
				splitStrings = currentString.trim().split("\\=");
				// Get the name
				if ("name".equals(splitStrings[0])) {
					name = splitStrings[1];
				}
				// Get the description
				else if ("description".equals(splitStrings[0])) {
					description = splitStrings[1];
				}
				// Get the default value
				else if ("defaultValue".equals(splitStrings[0])) {
					defaultValue = splitStrings[1];
				}
				// Get the AllowedValueType
				else if ("allowedValueType".equals(splitStrings[0])) {
					// this.setAllowedValueType(AllowedValueType
					// .valueOf(splitStrings[1]));
					valueType = splitStrings[1];
				}
				// Get the AllowedValues
				else if ("allowedValue".equals(splitStrings[0])) {
//					this.setAllowedValues(Arrays.asList(splitStrings[1]));// allowedValues);
					allowed.add(splitStrings[1]);
				}
				// Get the tag
				else if ("tag".equals(splitStrings[0])) {
					tag = splitStrings[1];
				}
				// Get the parent
				// else if ("parent".equals(splitStrings[0])) {
				// setParent(splitStrings[1]);
				// }
				// Get the group name
				else if ("group".equals(splitStrings[0])) {
					currentGroup = splitStrings[1];
				}
				// Check for an invalid tag. If it is found, throw an exception.
				else if (!validKeys.contains(splitStrings[0])) {
					throw new IOException("Invalid PSF statement: " + currentString);
				}
			}
		}

		
		if ("Discrete".equals(valueType)) {
			retEntry = new DiscreteEntry(allowed.toArray(new String[allowed.size()]));
		} else if ("Continuous".equals(valueType)) {
			retEntry = new ContinuousEntry(allowed.toArray(new String[allowed.size()]));
		} else if ("Undefined".equals(valueType)) {
			retEntry = new StringEntry();
		}
		
		retEntry.setName(name);
		retEntry.setDefaultValue(defaultValue);
		retEntry.setValue(defaultValue);
		retEntry.setDescription(description);
		retEntry.setTag(tag);
		
		return retEntry;
	}

	/**
	 * <p>
	 * This operation gets the name and description of the Form from the lines
	 * of text from the PSF file.
	 * </p>
	 * 
	 * @param lines
	 *            <p>
	 *            The lines of text from the PSF file.
	 *            </p>
	 */
	private void getFormNameAndDescription(ArrayList<String> lines) {

		// Local Declarations
		boolean hasName = false, hasDescription = false;
		String[] splitLines = { "", "" };

		// Loop over the lines and get the Form's name and description
		for (String currentLine : lines) {
			splitLines = currentLine.split("=");
			if (currentLine.startsWith("formName")) {
				setName(splitLines[1].trim());
				hasName = true;
			} else if (currentLine.startsWith("formDescription")) {
				setDescription(splitLines[1].trim());
				hasDescription = true;
			} else if (hasName && hasDescription) {
				break;
			}
		}

	}

	/**
	 * <p>
	 * An operation that sets up the row templates to the TableComponents in the
	 * form's component list.
	 * </p>
	 * 
	 */
	private void setupRowTemplates() {

		JanuaryObject compRef = null;
		TableComponent tableRef = null;
		ArrayList<IEntry> tempArray = null;

		// Iterate through the components list and see if the name
		// is in the rowTemplates list.
		for (int i = 0; i < this.getComponents().size(); i++) {
			compRef = (JanuaryObject) this.getComponents().get(i);
			// If it exists, add the ArrayList to the TableComponent via
			// set up row template.
			if (rowTemplates.containsKey(compRef.getName())) {
				tempArray = rowTemplates.get(compRef.getName());
				tableRef = (TableComponent) compRef;
				tableRef.setRowTemplate(tempArray);
			}
		}

	}
}