
public class Meeting
{
	private boolean forced;
	private Time meetingTime;
	private ComponentID meetingType;
	private CourseID meetingCourse;
	private DayOfWeek meetingDay;
	private Professor meetingProf;
	private RoomNumber meetingRoom;
	private Date meetingDate;
	private ArrayList<Meeting> allMeetings;
	
	public Meeting(String line)
	{
		//The String line will be the string format of one line of the CSV file
		
		String[] info = line.split(",");
		//This will be the order of data in the array:
		//Course ID, Component ID, Start Date, End Date, Day, Start Time, Duration, Pattern Day, Pattern Start Time, Pattern Duration, Building ID, Room Number, Surname

		if(info[4] != null)
			forced = true;
		else if(info[7] != null)
			forced = false;
		//One thing i'm not too sure about is what we're going to do about the exam slot lines.
		
		meetingType = new ComponentID(info[1]);
		meetingCourse = new CourseID(info[0]);
		if(forced)
		{
			meetingDay = DayOfWeek.fromString(info[4]);
			String[] startTime = info[5].split(":");
			String[] duration = info[6].split(":");
			meetingTime = new Time(Integer.parseInt(startTime[0]), Integer.parseInt(startTime[1]), Integer.parseInt(duration[0]), Integer.parseInt(duration[1]));
		}
		
		else if(!forced)
		{
			meetingDay = DayOfWeek.fromString(info[7]);
			String[] startTime = info[8].split(":");
			String[] duration = info[9].split(":");
			meetingTime = new Time(Integer.parseInt(startTime[0]), Integer.parseInt(startTime[1]), Integer.parseInt(duration[0]), Integer.parseInt(duration[1]));

		}
		
		meetingProf = new Professor(info[12]);
		meetingRoom = new RoomNumber(info[11]);
		meetingDate = new Date(info[2],info[3]);
		allMeetings.add();
	}
	
	public void setType(String ID)
	{
		meetingType = new ComponentID(ID);
	}
	public ComponentID getType()
	{
		return meetingType;
	}
	
	public void setCourse(String course)
	{
		meetingCourse = new CourseID(course);
	}
	
	public CourseID getCourse()
	{
		return meetingCourse;
	}
	
	public void setDate(String start, String end)
	{
		meetingDate = new Date(start, end);
	}
	
	public Date getDate()
	{
		return meetingDate;
	}
	
	public void setDay(String day)
	{
		meetingDay = DayOfWeek.fromString(day);
	}
	
	public DayOfWeek getDay()
	{
		return meetingDay;
	}
	
	public void setProf(String name)
	{
		meetingProf = new Professor(name);
	}
	
	public Professor getProf()
	{
		return meetingProf;
	}
	
	public void setRoom(String room)
	{
		meetingRoom = new RoomNumber(room);
	}
	
	public RoomNumber getRoom()
	{
		return meetingRoom;
	}
	
	public void setTime(String start, String end)
	{
		String[] startTime = start.split(":");
		String[] endTime = end.split(":");
		meetingTime = new Time(Integer.parseInt(startTime[0]), Integer.parseInt(startTime[1]), Integer.parseInt(endTime[0]), Integer.parseInt(endTime[1]));
	}
	
	public Time getTime()
	{
		return meetingTime;
	}
	
	public ArrayList<Meeting> getAllMeetings()
	{
		return allMeetings;
	}
	
	public void compareMeetings(Meeting m)
	{
		//Instead of having a bunch of getters to use in the master schedule I thought it would be more streamlined if there was just one method
		//that checked if 2 meetings collide with one another that could be used by any other class.
		boolean timeCollision = false;
		boolean roomCollision = false;
		boolean profCollision = false;
		
		if(meetingTime.overlapTime(m.meetingTime))
		{
			timeCollision = true;
			// Creates a colour change or some warning label that shows a collision occurs
		}
		if(meetingRoom.equals(m.meetingRoom) && timeCollision)
		{
			roomCollision = true;
			//Creates a colour change or some warning label that shows a collision
		}
		if(meetingProf.equals(m.meetingProf) && timeCollision && !roomCollision)
		{
			profCollision = true;
			//Same as the other 2 =P
		}
	}
}
