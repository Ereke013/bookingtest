package kz.iitu.bookinghotels.services;

import kz.iitu.bookinghotels.entities.Booking;
import kz.iitu.bookinghotels.entities.Guest;
import kz.iitu.bookinghotels.models.GuestDto;
import kz.iitu.bookinghotels.repositories.BookingRepository;
import kz.iitu.bookinghotels.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GuestService guestService;

    public Booking addBooking(Booking booking) {
        Guest guest = guestService.getGuestByEmail(booking.getGuest().getEmail());
        if (guest == null) {
            guest = booking.getGuest();
            guest = guestService.addGuest(guest);
        }

        booking.setGuest(guest);

        return bookingRepository.save(booking);
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> getBookingByGuest(String email, String phone) {
        return bookingRepository.findAllByGuest_EmailAndAndGuest_Phone(email, phone);
    }

    public void deleteBooking(Booking booking) {
        bookingRepository.delete(booking);
    }

    public List<Booking> getAllList() {
        return bookingRepository.findAll();
    }
}
