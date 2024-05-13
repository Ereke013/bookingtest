package kz.iitu.bookinghotels.controllers;


import kz.iitu.bookinghotels.entities.Guest;
import kz.iitu.bookinghotels.models.GuestDto;
import kz.iitu.bookinghotels.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllGuests() {
        return new ResponseEntity<>(this.guestService.getAllList(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getGuestById(@PathVariable(name = "id") Long id) {
        GuestDto guest = this.guestService.getGuestById(id);
        if (guest != null) {
            return ResponseEntity.ok(guest);
        }
        return null;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateGuest(@RequestBody Guest guest, @PathVariable(name = "id") Long id) {
        GuestDto savedGuest = this.guestService.updateGuest(guest, id);
        if (savedGuest == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(savedGuest);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteGuestById(@PathVariable(name = "id") Long id) {
        this.guestService.deleteGuest(id);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addGuest(@RequestBody Guest guest) {
        if (guest != null) {
            this.guestService.addGuest(guest);
            return new ResponseEntity<>(guest, HttpStatus.OK);
        }
        return null;
    }
}
