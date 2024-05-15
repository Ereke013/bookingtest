package kz.iitu.bookinghotels.controllers;


import kz.iitu.bookinghotels.entities.Booking;
import kz.iitu.bookinghotels.models.BookingGuestDto;
import kz.iitu.bookinghotels.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllBookings() {
        return new ResponseEntity<>(this.bookingService.getAllList(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable(name = "id") Long id) {
        Booking booking = this.bookingService.getBookingById(id);
        if (booking != null) {
            return ResponseEntity.ok(booking);
        }
        return null;
    }

    @PostMapping(value = "/by-guest")
    public ResponseEntity<?> getBookingByGuestId(@RequestBody BookingGuestDto bookingGuestDto) {
        return ResponseEntity.ok(this.bookingService.getBookingByGuest(bookingGuestDto.getEmail(), bookingGuestDto.getPhone()));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateBooking(@RequestBody Booking booking, @PathVariable(name = "id") Long id) {
        Booking bookingOld = this.bookingService.getBookingById(id);
        if (bookingOld != null) {
            bookingOld.setRoom(booking.getRoom());
            bookingOld.setGuest(booking.getGuest());
            bookingOld.setCheck_in_date(booking.getCheck_in_date());
            bookingOld.setCheck_out_date(booking.getCheck_out_date());
            bookingOld.setTotal_costs(booking.getTotal_costs());

            this.bookingService.saveBooking(bookingOld);
        }

        return ResponseEntity.ok(bookingOld);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteBookingById(@PathVariable(name = "id") Long id) {
        Booking booking = this.bookingService.getBookingById(id);
        if (booking != null) {
            this.bookingService.deleteBooking(booking);
            return ResponseEntity.ok(booking);
        }
        return null;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addBooking(@RequestBody Booking booking) {
        if (booking != null) {
            return new ResponseEntity<>(this.bookingService.addBooking(booking), HttpStatus.OK);
        }
        return null;
    }
}
