package dao;

import java.util.List;

import model.Room;

public interface RoomDao {

	public void save(Room room);
	public boolean canIn(int roomID);
	public void updateState(int roomID);
	public Room find(int roomID);
	public List<Room> getForCEO();
	public void approve();

}
