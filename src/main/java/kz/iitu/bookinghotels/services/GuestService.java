package kz.iitu.bookinghotels.services;

import kz.iitu.bookinghotels.entities.Guest;
import kz.iitu.bookinghotels.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public Guest addGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest updateGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest getGuestById(Long id) {
        return guestRepository.findById(id).orElse(null);
    }

    public void deleteGuest(Guest booking) {
        guestRepository.delete(booking);
    }

    public List<Guest> getAllList() {
        return guestRepository.findAll();
    }
}
