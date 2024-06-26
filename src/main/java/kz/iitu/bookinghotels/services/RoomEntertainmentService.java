package kz.iitu.bookinghotels.services;

import kz.iitu.bookinghotels.entities.RoomEntertainment;
import kz.iitu.bookinghotels.models.RoomEntertainmentId;
import kz.iitu.bookinghotels.repositories.RoomEntertainmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomEntertainmentService {
    @Autowired
    private RoomEntertainmentRepository roomEntertainmentRepository;

    public RoomEntertainment addRoomEntertainment(RoomEntertainment roomEntertainment) {
        return roomEntertainmentRepository.save(roomEntertainment);
    }

    public RoomEntertainment updateRoomEntertainment(RoomEntertainment roomEntertainment) {
        return roomEntertainmentRepository.save(roomEntertainment);
    }


    public RoomEntertainment getRoomEntertainmentById(RoomEntertainmentId roomEntertainmentId) {
        return this.roomEntertainmentRepository.findById(roomEntertainmentId).orElse(null);
    }

    public void deleteRoomEntertainment(RoomEntertainment booking) {
        roomEntertainmentRepository.delete(booking);
    }

    public List<RoomEntertainment> getAllList() {
        return roomEntertainmentRepository.findAll();
    }
}
