package cpsc101.highoctane.model;

/**
 * A simple class that keeps track of a professors name. Some lines from the CSV just have CourseIDs for professors
 * 
 * @author Ryley
 * @version 0.02
 */
public class Professor
{
	//the name of this professor. will be the name of the course ID if there's no professor
	private String myName;
	
	/**
	 * Creates a professor with the given name
	 * 
	 * @param name the name of this professor
	 */
	public Professor(String name)
	{
		myName = name;
	}
	
	/**
	 * gets the name of this professor. returns a course code if no professor is specified
	 * 
	 * @return the name of this professor
	 */
	public String getName()
	{
		return myName;
	}
	
	/**
	 * checks if two professors have the same name.
	 * DOESN'T CURRENTLY ACCOUNT FOR COURSE-CODE-NAMES
	 * should probably check to see if the name is a course code and return false,
	 * because course codes are not people and should not conflict
	 * 
	 * @param other the other professor to compare
	 * @return true if these professors have the same name (EVEN IF IT'S JUST A COURSE CODE)
	 */
	public boolean equals(Professor other)
	{
		return getName().equalsIgnoreCase(other.getName());
	}
	
	/**
	 * allows the object to be treated as a string
	 * 
	 * @return this professor's name
	 */
	@Override
	public String toString()
	{
		return getName();
	}
}
