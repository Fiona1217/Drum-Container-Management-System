/* File name: Drum.java
 * Author: Fiona Ang, 041151067
 * Course: CST8284 – OOP
 * Assignment: Assignment 2
 * Due date: March 23, 2025 11:59 PM
 * Professor: Amal Ibrahim
 * Purpose: This class contains the get, set, and worker methods for fileSize 
 * and downloadLink of Drum.
 * Class list: Drum, FlammableDrum, ToxicDrum.
 */

/**
 * DESCRIPTION: 
 * @version: openjdk 21.0.4 2024-07-16 LTS
 * @since: javac 21.0.4
 * @see java.lang.Object
 * @author Fiona Ang
 */

package domain;

/**
 * Sample Drum class for test purposes.
 * This class does not implement the UML class diagram specifications.
 * You must modify this class to adhere to the UML specs.
 * Hint: the Drum class contains an abstract method, "capacity()".
 */
public abstract class Drum {
	/**
	 * Height of Drum.
	 */
	private float height = 0;
	
	/**
	 * Diameter of Drum.
	 */
	private float diameter = 0;
	
	/**
	 * Contents of Drum.
	 */
	private String contents = "UNKNOWN";
	
	/**
	 * Default constructor of Drum.
	 */
	public Drum() {
		
	}
	
	/**
	 * Overloaded constructor of Drum.
	 * @param height The height of Drum.
	 * @param diameter The diameter of Drum.
	 */
	public Drum(float height, float diameter) {
		this.height = height;
		this.diameter = diameter;
	}
	
	/**
	 * Overloaded constructor of Drum.
	 * @param height The height of Drum.
	 * @param diameter The diameter of Drum.
	 * @param contents The contents of Drum.
	 */
	public Drum(float height, float diameter, String contents) {
		this.height = height;
		this.diameter = diameter;
		this.contents = contents;
	}
	
	/**
	 * The setter for height which sets the height of Drum.
	 * @param height The height of Drum
	 */
	public void setHeight(float height) {
		this.height = height;
	}
	
	/**
	 * The setter for diameter which sets the diameter of Drum.
	 * @param diameter The diameter of Drum
	 */
	public void setDiameter(float diameter) {
		this.diameter = diameter;
	}
	
	/**
	 * The setter for contents which sets the contents of Drum.
	 * @param contents The contents of Drum
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	/**
	 * The getter for height which returns the height of Drum.
	 * @return The height of Drum
	 */
	public float getHeight() {
		return height;
	}
	
	/**
	 * The getter for diameter which returns the diameter of Drum.
	 * @return The diameter of Drum
	 */
	public float getDiameter() {
		return diameter;
	}
	
	/**
	 * The getter for contents which returns the contents of Drum.
	 * @return The contents of Drum
	 */
	public String getContents() {
		return contents;
	}
	
	/**
	 * The toString method which returns a string in format.
	 */
	@Override
	public String toString() {
		return String.format("Drum [height= %.2f, diameter= %.2f, contents= %s]", height, diameter, contents);
	}
	
	/**
	 * The abstract method of capacity.
	 * @return the result of the calculated capacity based on the type of drums.
	 */
	public abstract float capacity();

}
