package kz.iitu.bookinghotels.controllers;


import kz.iitu.bookinghotels.entities.RoomService;
import kz.iitu.bookinghotels.models.RoomServiceId;
import kz.iitu.bookinghotels.services.RoomServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/room-services")
public class RoomServiceController {
    @Autowired
    private RoomServicesService roomServicesService;

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllServices() {
        return new ResponseEntity<>(this.roomServicesService.getAllList(), HttpStatus.OK);
    }

    @GetMapping(value = "/by-id")
    public ResponseEntity<?> getServiceByRoomId(@RequestBody RoomServiceId roomServiceId) {
        RoomService service = this.roomServicesService.getRoomServiceByRoomIdAndServiceId(roomServiceId);
        if (service != null) {
            return ResponseEntity.ok(service);
        }
        return null;
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateService(@RequestBody RoomService service) {
        RoomService serviceOld = this.roomServicesService.getRoomServiceByRoomIdAndServiceId(new RoomServiceId(service.getServices().getId(), service.getRoom().getId()));
        if (serviceOld != null) {
            serviceOld.setServices(service.getServices());
            serviceOld.setRoom(service.getRoom());
            serviceOld.setCost(service.getCost());

            this.roomServicesService.updateRoomService(serviceOld);
        }

        return ResponseEntity.ok(serviceOld);
    }

    @DeleteMapping(value = "/del")
    public ResponseEntity<?> deleteServiceById(@RequestBody RoomServiceId roomServiceId) {
        RoomService serviceOld = this.roomServicesService.getRoomServiceByRoomIdAndServiceId(roomServiceId);
        if (serviceOld != null) {
            this.roomServicesService.deleteRoomService(serviceOld);
            return ResponseEntity.ok(serviceOld);
        }
        return null;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addService(@RequestBody RoomService service) {
        if (service != null) {
            this.roomServicesService.addRoomService(service);
            return new ResponseEntity<>(service, HttpStatus.OK);
        }
        return null;
    }
}
