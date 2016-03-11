package cpsc101.highoctane.model;

/**
 * Stores a specific room
 * 
 * @author Ryley
 * @version 0.02
 */
public class RoomNumber
{
	//for now this is just stored in a bunch of constants
	//I thought about using an Enum, but i'm worried there's a building number i'm forgetting
	private static final int LAB4 = 4,
							 LIBRARY = 5,
							 CONFERENCE_CENTRE = 6,
							 AGORA = 7,
							 LAB8 = 8,
							 HEALTH_CENTRE = 9,
							 TEACHING_AND_LEARNING = 10;
	
	//member variables
	private String myRoom;
	private int myBuilding;
	private int myRoomNumber;
	
	/**
	 * Creates a room from a string in the format X-XXXX
	 * 
	 * @param room the entire room code
	 * @throws IllegalArgumentException
	 */
	public RoomNumber(String room) throws IllegalArgumentException
	{
		String[] splitRoom = room.split("-");
		
		if(splitRoom.length == 2)
		{
			try{
				myBuilding = Integer.valueOf(splitRoom[0]);
				myRoomNumber = Integer.valueOf(splitRoom[1]);
				myRoom = room;
			}catch(NumberFormatException _e){
				throw new IllegalArgumentException("The room number "+room+"Is not made up of numbers");
				//allows both types of errors to be handled the same way
			}
		}
		else
			throw new IllegalArgumentException("The room number "+room+" is not properly hyphen separated");
	}
	
	/**
	 * @return the entire room code
	 */
	public String getRoomCode()
	{
		return myRoom;
	}
	
	/**
	 * @return the number of the room. doesnt include the building
	 */
	public int getRoomNumber()
	{
		return myRoomNumber;
	}
	
	/**
	 * allows this Room to be tested for certain buildings (Stored in constants at the top)
	 * @return the building this room is in
	 */
	public int getBuildingNumber()
	{
		return myBuilding;
	}
	
	/**
	 * checks if two rooms are identical
	 * @param other the other room being tested
	 * @return true if they are the exact same room
	 */
	public boolean equals(RoomNumber other)
	{
		return (other.getBuildingNumber() == this.getBuildingNumber() &&
				other.getRoomNumber() == this.getRoomNumber());
	}
	
	/**
	 * allows the object to be treated as a string
	 * @return a string describing the object
	 */
	@Override
	public String toString()
	{
		return getRoomCode();
	}
}
