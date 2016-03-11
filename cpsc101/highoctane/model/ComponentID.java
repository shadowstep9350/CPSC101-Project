package cpsc101.highoctane.model;

/**
 * A courses type and its number
 * 
 * @author Ryley
 * @version 0.02
 */
public class ComponentID
{
	//Constants
	public static final char TUTORIAL_LETTER = 'T';
	public static final char LAB_LETTER = 'L';
	public static final char LECTURE_LETTER = 'A';
	
	//member variables
	String myComponent;
	char myComponentLetter;
	int myComponentNumber;
	
	/**
	 * Creates a Component ID from a single string
	 * has the precondition that the string has a single letter followed by a number
	 * 
	 * @param id the complete component ID
	 * @throws IllegalArgumentException
	 */
	public ComponentID(String id) throws IllegalArgumentException
	{
		//makes sure the component letter is capitalized
		myComponent = id.toUpperCase();
		myComponentLetter = myComponent.charAt(0);
		
		if(myComponentLetter <'A' || myComponentLetter >'Z')
			throw new IllegalArgumentException("The ComponentID "+id+" Does not start with a letter");
		
		try{
			myComponentNumber = Integer.parseInt(myComponent.substring(1));
		}catch(NumberFormatException _e){
			throw new IllegalArgumentException("The ComponentID "+id+" is not in the form of a letter and a number");
			//allows both errors to be handled in the same way
		}
	}
	
	/**
	 * Creates a Component ID from a type and a number
	 * 
	 * @param typeChar the component type
	 * @param sectionNum the component number
	 */
	public ComponentID(char typeChar, int sectionNum)
	{
		myComponent = ""+typeChar+sectionNum;
		myComponentLetter = typeChar;
		myComponentNumber = sectionNum;
	}
	
	/**
	 * @return this components complete ID
	 */
	public String getComponentID()
	{
		return myComponent;
	}
	
	/**
	 * @return this component's type
	 */
	public char getComponentLetter()
	{
		return myComponentLetter;
	}
	
	/**
	 * @return this component's number
	 */
	public int getComponentNumber()
	{
		return myComponentNumber;
	}
	
	/**
	 * @return true if this component has the LAB type
	 */
	public boolean isLab()
	{
		return myComponentLetter == LAB_LETTER;
	}
	
	/**
	 * @return true if this component has the LECTURE type
	 */
	public boolean isLecture()
	{
		return myComponentLetter == LECTURE_LETTER;
	}
	
	/**
	 * @return true if this component has the TUTORIAL type
	 */
	public boolean isTutorial()
	{
		return myComponentLetter == TUTORIAL_LETTER;
	}
	
	/**
	 * allows the object to be treated as a string
	 * 
	 * @return the entire component ID
	 */
	@Override
	public String toString()
	{
		return getComponentID();
	}
}
