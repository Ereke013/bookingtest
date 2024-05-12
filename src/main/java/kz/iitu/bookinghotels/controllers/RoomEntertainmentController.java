package kz.iitu.bookinghotels.controllers;


import kz.iitu.bookinghotels.entities.RoomEntertainment;
import kz.iitu.bookinghotels.models.RoomEntertainmentId;
import kz.iitu.bookinghotels.services.RoomEntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/room-entertainment")
public class RoomEntertainmentController {
    @Autowired
    private RoomEntertainmentService roomEntertainmentService;

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllEntertainments() {
        return new ResponseEntity<>(this.roomEntertainmentService.getAllList(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<?> getRoomEntertainmentById(@RequestBody RoomEntertainmentId roomEntertainmentId) {
        RoomEntertainment roomEntertainment = this.roomEntertainmentService.getRoomEntertainmentById(roomEntertainmentId);
        if (roomEntertainment != null) {
            return ResponseEntity.ok(roomEntertainment);
        }
        return null;
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateRoomEntertainment(@RequestBody RoomEntertainment roomEntertainment) {
        RoomEntertainment entertainmentOld = this.roomEntertainmentService.getRoomEntertainmentById(new RoomEntertainmentId(roomEntertainment.getEntertainment().getId(), roomEntertainment.getRoom().getId()));
        if (entertainmentOld != null) {
            entertainmentOld.setEntertainment(roomEntertainment.getEntertainment());
            entertainmentOld.setRoom(roomEntertainment.getRoom());
            entertainmentOld.setCost(roomEntertainment.getCost());

            this.roomEntertainmentService.updateRoomEntertainment(entertainmentOld);
        }

        return ResponseEntity.ok(entertainmentOld);
    }

    @DeleteMapping(value = "/del")
    public ResponseEntity<?> deleteRoomEntertainmentById(@RequestBody RoomEntertainmentId roomEntertainmentId) {
        RoomEntertainment entertainmentOld = this.roomEntertainmentService.getRoomEntertainmentById(roomEntertainmentId);
        if (entertainmentOld != null) {
            this.roomEntertainmentService.deleteRoomEntertainment(entertainmentOld);
            return ResponseEntity.ok(entertainmentOld);
        }
        return null;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addEntertainment(@RequestBody RoomEntertainment roomEntertainment) {
        if (roomEntertainment != null) {
            this.roomEntertainmentService.addRoomEntertainment(roomEntertainment);
            return new ResponseEntity<>(roomEntertainment, HttpStatus.OK);
        }
        return null;
    }
}
