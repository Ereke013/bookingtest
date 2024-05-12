package kz.iitu.bookinghotels.services;

import kz.iitu.bookinghotels.entities.Booking;
import kz.iitu.bookinghotels.repositories.BookingRepository;
import kz.iitu.bookinghotels.repositories.GuestRepository;
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
    private GuestRepository guestRepository;

    public Booking addBooking(Booking friend) {
        return bookingRepository.save(friend);
    }

    public Booking saveBooking(Booking friend) {
        return bookingRepository.save(friend);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public void deleteBooking(Booking booking) {
        bookingRepository.delete(booking);
    }

    public List<Booking> getAllList() {
        return bookingRepository.findAll();
    }
}
