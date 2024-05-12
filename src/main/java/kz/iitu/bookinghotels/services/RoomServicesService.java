package kz.iitu.bookinghotels.services;

import kz.iitu.bookinghotels.entities.RoomService;
import kz.iitu.bookinghotels.models.RoomServiceId;
import kz.iitu.bookinghotels.repositories.RoomServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServicesService {

    @Autowired
    private RoomServiceRepository roomServiceRepository;

    public RoomService addRoomService(RoomService roomService) {
        return roomServiceRepository.save(roomService);
    }

    public RoomService updateRoomService(RoomService roomService) {
        return roomServiceRepository.save(roomService);
    }

    public RoomService getRoomServiceByRoomIdAndServiceId(RoomServiceId roomServiceId) {
        return roomServiceRepository.findById(roomServiceId).orElse(null);
    }

    public void deleteRoomService(RoomService booking) {
        roomServiceRepository.delete(booking);
    }

    public List<RoomService> getAllList() {
        return roomServiceRepository.findAll();
    }
}
