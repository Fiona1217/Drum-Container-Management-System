/* File name: FlammableDrum.java
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
 * FlammableDrum.java - A subclass from parent class (Drum).
 */
public class FlammableDrum extends Drum {

	/**
	 * The flash point of FlammableDrum.
	 */
	private float flashpoint;
	
	/**
	 * The default constructor of FlammableDrum.
	 */
	public FlammableDrum() {
		super();
	}
	
	/**
	 * The overloaded constructor of FlammableDrum.
	 * @param height The height of FlammableDrum (Drum)
	 * @param diameter The diameter of FlammableDrum (Drum)
	 */
	public FlammableDrum(float height, float diameter) {
		super(height, diameter);
	}
	
	/**
	 * The overloaded constructor of FlammableDrum.
	 * @param height The height of FlammableDrum (Drum)
	 * @param diameter The diameter of FlammableDrum (Drum)
	 * @param contents The contents of FlammableDrum (Drum)
	 */
	public FlammableDrum(float height, float diameter, String contents) {
		super(height, diameter, contents);
	}
	
	/**
	 * The overloaded constructor of FlammableDrum.
	 * @param height The height of FlammableDrum (Drum)
	 * @param diameter The diameter of FlammableDrum (Drum)
	 * @param contents The contents of FlammableDrum (Drum)
	 * @param flashpoint The flash point of FlammableDrum
	 */
	public FlammableDrum(float height, float diameter, String contents, float flashpoint) {
		super(height, diameter, contents);
		this.flashpoint = flashpoint;
	}
	
	/**
	 * The setter for flash point which sets the flash point of FlammableDrum.
	 * @param flashpoint The flash point of FlammableDrum
	 */
	public void setFlashpoint(float flashpoint) {
		this.flashpoint = flashpoint;
	}
	
	/**
	 * The getter for flash point which returns the flash point of FlammableDrum.
	 * @return the flash point of FlammableDrum
	 */
	public float getFlashpoint() {
		return flashpoint;
	}
	
	/**
	 * The toString method which returns a string in format.
	 */
	@Override
	public String toString() {
		return String.format("%s: %s\n "
				+ "	::height= %.1f diameter= %.1f contents= %s flashpoint= %.1f ",getClass().getName(), 
				getClass().getSimpleName(), getHeight(), getDiameter(), 
				getContents(), flashpoint);
	}
	
	/**
	 * The capacity method which returns the result of the calculated capacity 
	 * based on the type of drums.
	 */
	@Override
	public float capacity() {
		float radius = getDiameter() / 2;
		double result1 = Math.PI * radius * radius * getHeight();
		float result2 = (float) result1;
		return result2;
	}
}
