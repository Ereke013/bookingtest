package kz.iitu.bookinghotels.services;

import kz.iitu.bookinghotels.entities.RoomService;
import kz.iitu.bookinghotels.repositories.RoomServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServicesService {

    @Autowired
    private RoomServiceRepository roomServiceRepository;

    public RoomService addRoomService(RoomService friend) {
        return roomServiceRepository.save(friend);
    }

//    public RoomService getRoomServiceById(Long id) {
//        return roomServiceRepository.findById(id).orElse(null);
//    }

    public void deleteRoomService(RoomService booking) {
        roomServiceRepository.delete(booking);
    }

    public List<RoomService> getAllList() {
        return roomServiceRepository.findAll();
    }
}
