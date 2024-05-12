package kz.iitu.bookinghotels.controllers;


import kz.iitu.bookinghotels.entities.Guest;
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
        Guest guest = this.guestService.getGuestById(id);
        if (guest != null) {
            return ResponseEntity.ok(guest);
        }
        return null;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateGuest(@RequestBody Guest guest, @PathVariable(name = "id") Long id) {
        Guest guestOld = this.guestService.getGuestById(id);
        if (guestOld != null) {
            guestOld.setFirst_name(guest.getFirst_name());
            guestOld.setLast_name(guest.getLast_name());
            guestOld.setEmail(guest.getEmail());
            guestOld.setPhone(guest.getPhone());

            this.guestService.updateGuest(guestOld);
        }

        return ResponseEntity.ok(guestOld);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteGuestById(@PathVariable(name = "id") Long id) {
        Guest guest = this.guestService.getGuestById(id);
        if (guest != null) {
            this.guestService.deleteGuest(guest);
            return ResponseEntity.ok(guest);
        }
        return null;
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
