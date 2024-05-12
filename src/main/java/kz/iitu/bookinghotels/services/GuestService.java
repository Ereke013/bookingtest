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

    public Guest addGuest(Guest friend) {
        return guestRepository.save(friend);
    }

    public Guest updateGuest(Guest friend) {
        return guestRepository.save(friend);
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
