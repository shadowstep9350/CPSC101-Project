/**
*Creates a Tutorial object that contains
*an ArrayList of all of the tutorials for
*the specified CourseID
*@author Thomas Smith
*@version 1.00
*/


public class Tutorial
{
	private ArrayList<Meeting> meetingList;
	
	public Tutorial()
	{
	}
	/**
	*Returns an array of all the meetings
	*that are a tutorial and have the same
	*CourseID as the CourseID sent as a parameter.
	*/
	public ArrayList<Meeting> getTutorial(CourseID course)
	{
		ArrayList allMeetings = Meeting.getAllMeetings();
		for(int i = 0;i < allMeetings.size();i++)
		{
			if((allMeetings.get(i).getType().isTutorial())&&(course.getCourseID()==allMeetings.get(i).getCourse().getCourseID()))
			{
				meetingList.add(allMeetings.get(i));
			}
		}
		return meetingList;
	}
	/**
	*Returns a string in the format of
	*"The tutorial for (CourseID) is on days: (Days) at (Time).
	*Just a placeholder until I figure out what I want this to display as a string.
	*/
	@Override
	public String toString()
	{
		String output = "The tutorial for "+meetingList.get(j).getType()+" is on days:";
		for(int j = 0;j<meetingList.size(); j++)
		{
			output = output+" "+meetingList.get(j).getDay();
		}
		return output+" at "+meetingList.get(0).getTime()+".";
	}
}