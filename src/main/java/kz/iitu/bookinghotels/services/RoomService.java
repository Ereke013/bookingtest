package kz.iitu.bookinghotels.services;

import kz.iitu.bookinghotels.entities.Room;
import kz.iitu.bookinghotels.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room saveRoom(Room friend) {
        return roomRepository.save(friend);
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public void deleteRoom(Room booking) {
        roomRepository.delete(booking);
    }

    public List<Room> getAllList() {
        return roomRepository.findAll();
    }
}
