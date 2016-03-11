/**
* Class that makes sure that the class time and duration make sense and creates an object with the times as variables.
*
* @author Duncan Render
* @version 1.01
*/
package cpsc101.highoctane.model;
import java.text.*;

public class Time
{
	private static DecimalFormat cf = new DecimalFormat("00,00"); //Lets us take numbers and display them as "hours:minutes".
	private static DecimalFormatSymbols symbols = cf.getDecimalFormatSymbols();
	private int Start_Time; //The time that the class starts. Kind of self-explanatory...
	private int Start_Hours; //The hour that the class starts at. 
	private int Start_Minutes; //The minute that the class starts at. This needs to be separate from hours at first because of csv format.
	private int duration; //The duration of the class.
	private int Duration_Minutes;
	private int Duration_Hours;
	private int End_Time; //Time that class ends.
	private String Meet_Time; //We can use the decimal format to make the start time into a string.
	private String End_of_Class; //Makes a string for the time that class ends, in case we want to show it somewhere.
	private boolean created = false;
	
	/**
	* The constructor for the class object.
	*
	* @param theStartHour The hour at which the class starts. 
	*							 I'm pretty sure the hour and minute need to be separate because of the csv file's format.
	*
	* @param theStartMinute The Minute at which the class starts.
	*
	* @param theDurationHour How many hours the class lasts.
	*
	* @param theDurationMinute How many minutes the class lasts. 
	*
	* Checks to see if the start and end of class is between 08:30 and 21:00. If not, it throws an exception.
	* Also I tried to make sure that you couldn't start the class before 21:00 and end it after 08:30. 
	* I have tested this particular case and it does work.
	*
	* Also does a bit of math to make sure the hour is between 0 and 23 and the minute is between 0 and 59.
	* It shouldn't actually ever change the number if the csv file is correct, but it's just there as a safeguard.
	*/
	public Time(int theStartHour, int theStartMinute, int theDurationHour, int theDurationMinute)
	{
		symbols.setGroupingSeparator(':');
		cf.setDecimalFormatSymbols(symbols);
		setHours(theStartHour);
		setMinutes(theStartMinute);
		setDurationHours(theDurationHour);
		setDurationMinutes(theDurationMinute);
		setStart();
		setEnd();
		setMeetTime();
		setEndofClass();
		validTimes();
		created = true;
	}
	
	//Here are the standard getters.
	public String getTime()
	{
		return Meet_Time;
	}
	
	public int getDuration()
	{
		setDuration();
		return duration;
	}
	
	public int getRawTime()
	{
		return Start_Time;
	}
	
	public int getRawEnd()
	{
		return End_Time;
	}
	
	public String getClassEnd()
	{
		return End_of_Class;
	}
	
	//And here are the setters
	public void setMinutes(int minutes) //sets the minutes for the start of class. If the minutes go to 60 or over adds and hour.
	{
		Start_Minutes = minutes%60;
		setHours(Start_Hours + minutes/60);
	}
	
	public void setHours(int hours) //sets the hours for the start of class and checks to make sure the times are still valid.
	{
		Start_Hours = hours%24;
		if(created) 
		{
			setStart();
			setEnd();
			setMeetTime();
			setEndofClass();
			validTimes();
		}
	}
	
	
	public void setDurationMinutes(int minutes)
	{
		Duration_Minutes = minutes%60;
		setDurationHours(Duration_Hours + minutes/60);
	}
	
	public void setDurationHours(int hours)
	{
		Duration_Hours = hours%24;
		if(created) 
		{
			setEnd();
			setEndofClass();
			validTimes();
		}
	}
	
	private void setDuration()
	{
		duration = Duration_Hours*100 + Duration_Minutes;
	}
	
	private void setStart()
	{
		Start_Time = Start_Hours*100 + Start_Minutes;
	}
	
	private void setEnd()
	{
		End_Time = (((Start_Hours + Duration_Hours) + (Start_Minutes + Duration_Minutes)/60)%24)*100 + (Start_Minutes + Duration_Minutes)%60;
	}
	
	private void setMeetTime()
	{
		Meet_Time = cf.format(Start_Time);
	}	
	
	private void setEndofClass()
	{
		End_of_Class = cf.format(End_Time);
	}
	
	/**
	* Checks to make sure that the class is between 8:30 and 21:00
	*
	* I added the exception because Ryley did that in his course id. I don't know if you guys want it like that though?
	*/
	private void validTimes() throws IllegalArgumentException
	{
		
		if (Start_Time < 830 || Start_Time >= 2100 || End_Time > 2100 || End_Time <= 830 || End_Time <= Start_Time)
		{ 
			throw new IllegalArgumentException("The course times (" + Meet_Time + ", " + End_of_Class + ") do no fit between 08:30 and 21:00");
		}		
		return;
	}
	
	/**
	* Checks if this time object's times overlap with another time object
	*
	* @return returns true if the two times overlap at all. Otherwise returns false.
	*/
	public boolean overlapTime(Time other) 
	{
		if ((other.getRawTime() >= Start_Time && other.getRawTime() <= End_Time) || (Start_Time >= other.getRawTime() && Start_Time <= other.getRawEnd()))
		{
			return true;
		}
		
		return false;
	}
	
}
