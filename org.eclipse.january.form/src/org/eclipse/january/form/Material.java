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
 *   Claire Saunders, Matthew Wang, Anna Wojtowicz, Kasper Gammeltoft
 *******************************************************************************/
package org.eclipse.january.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * This class represents physical Materials.
 * 
 * All materials have a name and a size. Other properties whose values are
 * normally double precision floating point numbers are stored as properties.
 * The list of properties available for a material can be retrieved by calling
 * getProperties() and the list of properties can be modified by calling
 * get/setProperty().
 * 
 * Materials can also be composed of other materials called "Components." Each
 * Material that comprises the the composite Materials should be set using the
 * addComponent() operation and the whole list of components can get retrieved
 * with the getComponents() operation. ICE makes no attempt to correct
 * mismatched sizes, etc. between components and composites.
 * 
 * @author Jay Jay Billings, Kasper Gammeltoft
 * 
 */
@XmlRootElement(name = "Material")
@XmlAccessorType(XmlAccessType.NONE)
public class Material implements Cloneable, Comparable<Material> {

	// Strings for property names.

	/**
	 * The atomic mass of the material. This is the name of that property.
	 */
	@XmlTransient
	public static final String ATOMIC_MASS = "M (amu)";

	/**
	 * The Atomic density of the material. This is the name of that property.
	 */
	@XmlTransient
	public static final String ATOMIC_DENSITY = "Dens (at/nm3)";

	/**
	 * The density (in g/cm^3) of the material. This is the name of that
	 * property.
	 */
	@XmlTransient
	public static final String DENSITY = "Dens (g/cm3)";

	/**
	 * The number density of the material. This is the name of that property.
	 */
	@XmlTransient
	public static final String NUMBER_DENSITY = "N (Ang^-3)";

	/**
	 * The Bound coherent scattering length of the material. This is the name of
	 * that property.
	 */
	@XmlTransient
	public static final String COHERENT_SCAT_LENGTH = "Coh b";

	/**
	 * The Bound incoherent scattering length of the material. This is the name
	 * of that property.
	 */
	@XmlTransient
	public static final String INCOHERENT_SCAT_LENGTH = "Inc b";

	/**
	 * The bound coherent scattering cross section of the material. This is the
	 * name of that property.
	 */
	@XmlTransient
	public static final String COHERENT_SCAT_X_SECTION = "Coh xs";

	/**
	 * The bound incoherent scattering cross section of the material. This is
	 * the name of that property.
	 */
	@XmlTransient
	public static final String INCOHERENT_SCAT_X_SECTION = "Inc xs";

	/**
	 * The scattering length density in (A^-2) of the material. This is the name
	 * of that property.
	 */
	@XmlTransient
	public static final String SCAT_LENGTH_DENSITY = "Scattering Length Density (A^-2)";

	/**
	 * The scattering cross section in (A^-2) of the material. This is the name
	 * of that property.
	 */
	@XmlTransient
	public static final String SCAT_X_SECTION = "Scattering Cross Section";

	/**
	 * The absorption cross section of the material. This is the name of that
	 * property.
	 */
	@XmlTransient
	public static final String ABS_X_SECTION = "Abs xs";

	/**
	 * The true or coherent mass absorption coefficient of the material. This is
	 * the name of that property.
	 */
	@XmlTransient
	public static final String MASS_ABS_COHERENT = "mmabs/l (Ang^-2)";

	/**
	 * The incoherent mass absorption coefficient of the material. This is the
	 * name of that property.
	 */
	@XmlTransient
	public static final String MASS_ABS_INCOHERENT = "mminc (Ang^-1)";

	/**
	 * The name of the material.
	 */
	@XmlElement
	private String name;

	/**
	 * The key-value pair map of properties for this material.
	 */
	@XmlElement(name = "properties")
	private HashMap<String, Double> properties;

	/**
	 * The list of components that comprise this material.
	 */
	@XmlElement(name = "components")
	// @XmlTransient
	private HashMap<String, MaterialStack> components;

	/**
	 * The constructor.
	 */
	public Material() {
		name = "";
		properties = new HashMap<String, Double>();
		components = new HashMap<String, MaterialStack>();
	}

	/**
	 * Get the name of the material.
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the material
	 * 
	 * @param matName
	 *            The name of the material. There are no restrictions on what it
	 *            may be.
	 */
	public void setName(String matName) {
		name = matName;
	}

	/**
	 * This operation returns the value of the material property with the given
	 * name.
	 * 
	 * @param key
	 *            The key/name of the property whose value should be returned
	 * @return the value or 0.0 if this value is not in the map, but never null.
	 */
	public double getProperty(String key) {
		double value = 0.0;
		if (properties.containsKey(key)) {
			value = properties.get(key);
		}
		return value;
	}

	/**
	 * This operation sets value of the material property with the given name.
	 * 
	 * @param key
	 *            The key/name of the property whose value should be set
	 * @param value
	 *            the property
	 */
	public void setProperty(String key, double value) {
		properties.put(key, value);
	}

	/**
	 * This operation removes a property from the material's properties list.
	 * 
	 * @param key
	 *            The name of the property that should be removed.
	 */
	public void removeProperty(String key) {
		if (properties.containsKey(key)) {
			properties.remove(key);
		}
	}

	/**
	 * This operation returns the full set of properties for this material.
	 * 
	 * @return A map of the properties. Changing this map will not change the
	 *         internal properties of the material.
	 */
	public Map<String, Double> getProperties() {
		return new HashMap<String, Double>(properties);
	}

	/**
	 * This operation returns the list of materials that compose this material.
	 * 
	 * @return The list of Materials that make up this one. Changing this list
	 *         will not affect list stored by the Material.
	 */
	public List<MaterialStack> getComponents() {
		return new ArrayList<MaterialStack>(components.values());
	}

	/**
	 * This operation adds a component to this material, effectively marking
	 * this Material as being a composite of others. It tries to see if the
	 * material added already exists in this material's components, and if so
	 * just increments the amount. Otherwise, adds the new material as a
	 * material stack with an amount of 1.
	 * 
	 * @param component
	 *            The material that is a component of this material to be added.
	 */
	public void addComponent(Material component) {

		// Pass it on to the other method.
		MaterialStack stack = new MaterialStack(component, 1);
		addComponent(stack);

		return;
	}

	/**
	 * This operation adds a component to this material, effectivly marking this
	 * Material as being a composite of others. It tries to see if the material
	 * stack given is a stack of an existing compoenent of this material, and if
	 * so updates the amount for that stack. Otherwise, adds the new stack to
	 * the list of components.
	 * 
	 * @param stack
	 *            the stack of material to add
	 */
	public void addComponent(MaterialStack stack) {

		// Pull the material and check the map
		Material component = stack.getMaterial();
		if (components.containsKey(component.name)) {
			// Increment the size of the material stack in the map by the amount
			// in the new stack.
			components.get(component.name).addAmount(stack.getAmount());
		} else {
			// Not found already, create a new material stack and add to
			// components
			components.put(component.getName(), stack);
		}
	}

	/**
	 * This operation checks to see if the given material at all is a component
	 * of this material.
	 * 
	 * @param material
	 *            The Material to check with
	 * @return Returns true if the given material is in the compoents list of
	 *         this one. Returns false if otherwise.
	 */
	public boolean isComponent(Material material) {
		return components.containsKey(material.getName());

	}

	/**
	 * This operation overrides Object.equals() to tailor its behavior for
	 * materials.
	 * 
	 * @param other
	 *            The other Object to compare against this one
	 * @return true if they are equal, false otherwise
	 */
	@Override
	public boolean equals(Object other) {
		// Local Declarations
		boolean retVal = false;

		// Don't inspect the input if it is not a Material or if it is null
		if (other != null && other instanceof Material) {
			// Check the reference
			if (this == other) {
				retVal = true;
			} else {
				Material otherMaterial = (Material) other;
				// Check each member
				boolean val1 = this.name.equals(otherMaterial.name);
				boolean val2 = this.components.equals(otherMaterial.components);
				boolean val3 = this.properties.equals(otherMaterial.properties);
				retVal = val1 && val2 && val3;
			}
		}

		return retVal;
	}

	/**
	 * This operation overrides Object.hashCode to return the proper hash for
	 * Materials.
	 * 
	 * @return the hash
	 */
	@Override
	public int hashCode() {
		// Local Declarations
		int hash = 8;

		// Compute the hash code
		hash = 31 * hash + name.hashCode();
		hash = 31 * hash + properties.hashCode();
		hash = 31 * hash + components.hashCode();

		return hash;
	}

	/**
	 * This operation copies the content of the incoming material into this
	 * material.
	 * 
	 * @param material
	 *            the material to copy
	 */
	public void copy(Material material) {
		// Don't copy the input if it is not a Material or if it is null
		if (material != null && material != this) {
			this.name = material.name;
			this.properties = new HashMap<String, Double>(material.properties);
			this.components = new HashMap<String, MaterialStack>(
					material.components);
		}
	}

	/**
	 * This operation updates the properties for this material based on the code
	 * from John Ankner's compound calculator written in Visual Basic. The code
	 * was ported for the Reflectivity Model. Calculates the number density,
	 * scattering length density, true (coherent) scattering length absorption
	 * coefficient, and the incoherent scattering length absorption coefficient
	 * all from the density of the material (in g/cm^3) and its components. If
	 * called on a elemental material, does nothing.
	 */
	public void updateProperties() {

		// Makes sure to not try to recalculate the values for an element or
		// isotope.
		if (!isElemental()) {
			// Variables and constants
			final double nA = 6.02E23;
			double numberDensity = 0;
			double muMAbs = 0;
			double muMInc = 0;
			double b = 0;

			double density = getProperty(DENSITY);
			// Get the molecular mass
			double molMass = 0;
			List<MaterialStack> list = getComponents();
			for (MaterialStack stack : list) {

				molMass += (stack.getAmount()
						* (stack.getMaterial().getProperty(ATOMIC_MASS)));
				System.out
						.println("adding mass: " + stack.getMaterial().getName()
								+ " amount: " + molMass);
			}

			// Check if valid inputs
			if (list.size() > 0 && molMass >= 1) {

				// Get the number density
				numberDensity = (1E-24) * (nA) * (density / molMass);

				// Iterate over the list and create the new material's
				// properties
				for (int j = 0; j < list.size(); j++) {
					MaterialStack stack = list.get(j);
					Material mat = stack.getMaterial();
					int N = stack.getAmount();

					// Sum the scattering length for the new material
					double cohb = 1E-5 * mat.getProperty(COHERENT_SCAT_LENGTH);

					// The real part of the scattering length
					b += N * cohb;

					// Determine true mass absorption coefficient
					double massPercent = mat.getProperty(ATOMIC_MASS) / molMass;
					muMAbs += N * massPercent
							* (mat.getProperty(MASS_ABS_COHERENT));

					// Determine incoherent mass absorption coefficient
					muMInc += N * massPercent
							* (mat.getProperty(MASS_ABS_INCOHERENT));

				}

			}

			// Now just write these values to the new material's properties.

			// Set the new total mass for the material
			setProperty(ATOMIC_MASS, molMass);
			// Set the number density
			setProperty(NUMBER_DENSITY, numberDensity);
			// Set the scattering length density
			setProperty(SCAT_LENGTH_DENSITY, numberDensity * b);
			// Set the true scattering length absorption coefficient
			muMAbs *= 1E-24 * getProperty(DENSITY);
			setProperty(MASS_ABS_COHERENT, muMAbs);
			// Set the incoherent scattering length absorption coefficient
			muMInc *= 1E-24 * getProperty(DENSITY);
			setProperty(MASS_ABS_INCOHERENT, muMInc);
		}
	}

	/**
	 * Gets if this material is elemental (not a compound/composite). It must
	 * have no components to be elemental.
	 * 
	 * @return Returns true if this material is elemental, false if otherwise.
	 */
	public boolean isElemental() {
		return components.isEmpty();
	}

	/**
	 * Gets the number before the element denoting which isotope or form of an
	 * element or compound this material represents. If it is a compound or
	 * composite, will return 0.
	 * 
	 * @return The number of this isotope, as an int. Will return 0 if this is a
	 *         pure element (no number preceding its name) or if this material
	 *         is not elemental.
	 */
	public int getIsotopicNumber() {
		// Get an empty string to build off of
		String numStr = "";
		int retVal;
		// If this is a component it should not truly have isotopes and thus no
		// isotopic number.
		if (!(components.isEmpty())) {
			retVal = 0;
		} else {
			// Iterate over the characters in the name to pull out the isotope
			// number. it is assumed that the name will follow the format xxxYy,
			// where x is a digit and y is a letter.
			for (int i = 0; i < name.length(); i++) {
				if (Character.isDigit(name.charAt(i))) {
					numStr += name.charAt(i);
				} else {
					break;
				}
			}
			// Get the isotope number in int form. If no x values in name,
			// return 0.
			if (numStr.equals("")) {
				retVal = 0;
			} else {
				retVal = Integer.parseInt(numStr);
			}
		}
		return retVal;
	}

	/**
	 * Gets the elemental or compound name for this material. Note- this will
	 * return the same string for two different isotopes of the same element.
	 * 
	 * @return A String containing the name of the element or compound that this
	 *         material represents.
	 */
	public String getElementalName() {
		// A string to build on
		String nameStr = "";

		// If it is a composite, just have the elemental name be the full name
		// of the composite.
		if (!components.isEmpty()) {
			nameStr = name;
		} else {
			// Iterate over the name of the material, it is assumed that the
			// name follow the form xxxYy, where x is a digit and y is a letter.
			for (int i = name.length() - 1; i >= 0; i--) {
				if (Character.isLetter(name.charAt(i))) {
					nameStr = name.charAt(i) + nameStr;
				} else {
					break;
				}
			}
		}
		return nameStr;
	}

	/**
	 * This operation clones the material and creates a completely new material
	 * with the same information.
	 * 
	 * @return The clone
	 */
	@Override
	public Object clone() {
		// Create a new Material, copy everything into it and return it
		Material clone = new Material();
		clone.copy(this);
		return clone;
	}

	/**
	 * This operation compares materials so that they may be sorted when in
	 * lists. Implements the Comparable interface. Uses only the material's
	 * names, as these should be the best unique identifiers for sorting.
	 * 
	 * @param otherMaterial
	 *            The other material to be compared. Will return 0 if this is
	 *            not a material object or a subclass!
	 * @return Returns a value less than one if it is to be closer to index 0
	 *         than the other material. Returns a value of exactly 0 if it is
	 *         equal to the other material. Finally, returns a value of greater
	 *         than one if it is to be further from index 0 than the other
	 *         material.
	 */
	@Override
	public int compareTo(Material otherMaterial) {

		int returnVal = 0;

		// The name of the element or compound for the two materials
		String thisElement = getElementalName();
		String otherElement = otherMaterial.getElementalName();

		// The isotopic numbers for the two materials
		int thisNum = getIsotopicNumber();
		int otherNum = otherMaterial.getIsotopicNumber();

		// Dealing with the same element, sort by isotope number
		if (thisElement.toLowerCase().equals(otherElement.toLowerCase())) {

			// Sort from lower isotopic number to greater
			if (thisNum < otherNum) {
				returnVal = -1;
			} else if (thisNum > otherNum) {
				returnVal = 1;
			} else {
				returnVal = 0;
			}

			// Dealing with different elements, sort by name.
		} else {
			returnVal = thisElement.toLowerCase()
					.compareTo(otherElement.toLowerCase());
		}

		// Return the sorting value for these two Materials
		return returnVal;

	}

}
