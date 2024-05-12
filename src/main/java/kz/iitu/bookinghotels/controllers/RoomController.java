package kz.iitu.bookinghotels.controllers;


import kz.iitu.bookinghotels.entities.Room;
import kz.iitu.bookinghotels.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllRooms() {
        return new ResponseEntity<>(this.roomService.getAllList(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable(name = "id") Long id) {
        Room room = this.roomService.getRoomById(id);
        if (room != null) {
            return ResponseEntity.ok(room);
        }
        return null;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateRoom(@RequestBody Room room, @PathVariable(name = "id") Long id) {
        Room roomOld = this.roomService.getRoomById(id);
        if (roomOld == null) {
            return ResponseEntity.notFound().build();
        }

        roomOld.setRoom_type(room.getRoom_type());
        roomOld.setArea(room.getArea());
        roomOld.setHotel(room.getHotel());
        roomOld.setBase_price(room.getBase_price());

        this.roomService.saveRoom(roomOld);


        return ResponseEntity.ok(roomOld);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteRoomById(@PathVariable(name = "id") Long id) {
        Room room = this.roomService.getRoomById(id);
        if (room != null) {
            this.roomService.deleteRoom(room);
            return ResponseEntity.ok(room);
        }
        return null;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addRoom(@RequestBody Room room) {
        if (room != null) {
            this.roomService.saveRoom(room);
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
        return null;
    }
}
