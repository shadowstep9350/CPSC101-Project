package cpsc101.highoctane.model;

/**
 * The four letter ID and the associated three digit code
 * 
 * @author Ryley
 * @version 0.02
 */
public class CourseID
{
	private String myCourseID;
	private String mySubjectCode;
	private int myCourseNumber;
	
	/**
	 * creates a courseID.
	 * has the precondition that there must be a four letter code and a three digit number
	 * 
	 * @param id The complete course ID
	 * @throws IllegalArgumentException if the course ID is not 7 characters long
	 * @throws NumberFormatException if the 5th to 7th letters are not numbers
	 */
	public CourseID(String id) throws IllegalArgumentException
	{
		if(id.length() != 7)
			throw new IllegalArgumentException("The CourseID "+id+" is not in the form of 4 letters and 3 numbers");
		
		myCourseID = id;
		mySubjectCode = myCourseID.substring(0,4);
		try{
			myCourseNumber = Integer.parseInt(myCourseID.substring(4,7));
		}catch(NumberFormatException _e){
			throw new IllegalArgumentException("The CourseID "+id+" is not in the form of 4 letters and 3 numbers");
			//makes it so both kinds of errors can be handled in the same way
		}
	}
	
	/**
	 * @return the complete courseID code
	 */
	public String getCourseID()
	{
		return myCourseID;
	}
	
	/**
	 * @return the four letter subject code for this courseID
	 */
	public String getSubject()
	{
		return mySubjectCode;
	}
	
	/**
	 * @return the three digit code for this courseID
	 */
	public int getCourseNumber()
	{
		return myCourseNumber;
	}
	
	/**
	 * checks if two course IDs are identical
	 * 
	 * @param courseID the coureID object being compared
	 * @return true if both courses have an identical ID
	 */
	public boolean equals(CourseID other)
	{
		return getCourseID().equalsIgnoreCase(other.getCourseID());
	}
	
	/**
	 * Allows this object to be treated as a string
	 * 
	 * @return the entire course ID
	 */
	@Override
	public String toString()
	{
		return getCourseID();
	}
}
