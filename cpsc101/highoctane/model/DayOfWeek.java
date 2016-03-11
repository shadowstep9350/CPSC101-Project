package cpsc101.highoctane.model;

/**
 * Stores the day of the week. allows days to be compared easily
 * 
 * @author Ryley
 * @version 0.01
 */
public enum DayOfWeek
{
	MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
	
	/**
	 * Creates a DayOfWeek type from a string
	 * 
	 * @param day the day of the week in String format
	 * @return a DayOfWeek with the specified name
	 * @throws IllegalArgumentException if the name does not exist in this enum
	 */
	public static DayOfWeek fromString(String day) throws IllegalArgumentException
	{
		return DayOfWeek.valueOf(day.toUpperCase());
	}
}
