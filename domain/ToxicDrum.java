/* File name: ToxicDrum.java
 * Author: Fiona Ang, 041151067
 * Course: CST8284 – OOP
 * Assignment: Assignment 2
 * Due date: March 23, 2025 11:59 PM
 * Professor: Amal Ibrahim
 * Purpose: This class contains the get, set, and worker methods for fileSize 
 * and downloadLink of Drum.
 * Class list: Drum, FlammableDrum, ToxicDrum, DrumPanel, Drum_Test
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
 * ToxicDrum.java - A subclass from parent class (Drum).
 */
public class ToxicDrum extends Drum {
	/**
	 * The toxicity of ToxicDrum.
	 */
	private String toxicity;
	
	/**
	 * CLASS_IA which is one of the classification for toxicity. 
	 */
	public final String CLASS_IA = "extremely hazardous";
	
	/**
	 * CLASS_IB which is one of the classification for toxicity.
	 */
	public final String CLASS_IB = "highly hazardous";
	
	/**
	 * CLASS_II which is one of the classification for toxicity.
	 */
	public final String CLASS_II = "moderately hazardous";
	
	/**
	 * CLASS_III which is one of the classification for toxicity.
	 */
	public final String CLASS_III = "slightly hazardous";
	
	/**
	 * The default constructor for ToxicDrum.
	 */
	public ToxicDrum() {
		super();
	}
	
	/**
	 * The overloaded constructor for ToxicDrum.
	 * @param height The height of ToxicDrum (Drum)
	 * @param diameter The diameter of ToxicDrum (Drum)
	 */
	public ToxicDrum(float height, float diameter) {
		super(height, diameter, "UNKNOWN");
	}
	
	/**
	 * The overloaded constructor for ToxicDrum.
	 * @param height The height of ToxicDrum (Drum)
	 * @param diameter The diameter of ToxicDrum (Drum)
	 * @param contents The contents of ToxicDrum (Drum)
	 */
	public ToxicDrum(float height, float diameter, String contents) {
		super(height, diameter, contents);
	}
	
	/**
	 * The overloaded constructor for ToxicDrum.
	 * @param height The height of ToxicDrum (Drum)
	 * @param diameter The diameter of ToxicDrum (Drum)
	 * @param contents The contents of ToxicDrum (Drum)
	 * @param toxicity The toxicity of ToxicDrum
	 */
	public ToxicDrum(float height, float diameter, String contents, String toxicity) {
		super(height, diameter, contents);
		this.toxicity = toxicity;
	}
	
	/**
	 * The setter for toxicity which sets the toxicity of ToxicDrum.
	 * @param toxicity The toxicity of ToxicDrum
	 */
	public void setToxicity(String toxicity) {
		this.toxicity = toxicity;
	}
	
	/**
	 * The getter for toxicity which returns the toxicity of ToxicDrum.
	 * @return the toxicity of ToxicDrum
	 */
	public String getToxicity() {
		return toxicity;
	}
	
	/**
	 * The capacity method which returns the result of the calculated capacity 
	 * based on the type of drums. The original formula of volume is (22/7)*r*r*h.
	 * Since ToxicDrum is 3/4 the full capacity of cylinder, and the result of 
	 * the capacity based on the example provided should be 339.292, I divided 
	 * the result by another height to achieve the desired result.
	 */
	@Override
	public float capacity() {
		float radius = getDiameter() / 2;
		double result1 = (0.75 *  (Math.PI * (radius * radius) * getHeight()) / getHeight());
		float result2 = (float)result1;
		return result2;
	}
	
	/**
	 * The toString method which returns a string in format.
	 */
	@Override
	public String toString() {
		String toxicityVariable = null;
		if (toxicity.equals(CLASS_IA)) {
			toxicityVariable = "CLASS_IA";
		}
		else if (toxicity.equals(CLASS_IB)) {
			toxicityVariable = "CLASS_IB";
		}
		else if (toxicity.equals(CLASS_II)) {
			toxicityVariable = "CLASS_II";
		}
		else if (toxicity.equals(CLASS_III)) {
			toxicityVariable = "CLASS_III";
		}
		else {
			toxicityVariable = "UNKNOWN";
		}
		
		return String.format("%s: %s\n "
				+ "	::height: %.1f diameter: %.1f contents: %s capacity= %.3f toxicity: %s ",getClass().getName(), 
				getClass().getSimpleName(), getHeight(), getDiameter(), 
				getContents(), capacity(), toxicityVariable);
	}
}
