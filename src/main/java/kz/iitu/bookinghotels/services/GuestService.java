package kz.iitu.bookinghotels.services;

import kz.iitu.bookinghotels.entities.Guest;
import kz.iitu.bookinghotels.models.GuestDto;
import kz.iitu.bookinghotels.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public Guest addGuest(Guest newGuest) {
        return guestRepository.save(newGuest);
    }

    public GuestDto updateGuest(Guest guestToUpdate, Long id) {
        Guest guestOld = this.getGuestByIdInner(id);
        if (guestOld == null) {
            return null;
        }

        guestOld.setFirst_name(guestToUpdate.getFirst_name());
        guestOld.setLast_name(guestToUpdate.getLast_name());
        guestOld.setEmail(guestToUpdate.getEmail());
        guestOld.setPhone(guestToUpdate.getPhone());

        Guest guest = guestRepository.save(guestToUpdate);

        return new GuestDto(guest.getId(), guest.getFirst_name(), guest.getLast_name(),
                guest.getEmail(), guest.getPhone());
    }

    private Guest getGuestByIdInner(Long id) {
        return guestRepository.findById(id).orElse(null);
    }

    public Guest getGuestByEmail(String email) {
        return guestRepository.findByEmail(email);
    }

    public GuestDto getGuestById(Long id) {
        Guest guest = this.getGuestByIdInner(id);

        if (guest == null) {
            return null;
        }

        return new GuestDto(guest.getId(), guest.getFirst_name(), guest.getLast_name(),
                guest.getEmail(), guest.getPhone());
    }

    public void deleteGuest(Long id) {
        Guest guest = this.getGuestByIdInner(id);
        if (guest != null) {
            guestRepository.delete(guest);
        }
    }

    public List<GuestDto> getAllList() {
        return guestRepository.findAll()
                .stream()
                .map(guest ->
                        new GuestDto(guest.getId(), guest.getFirst_name(), guest.getLast_name(),
                                guest.getEmail(), guest.getPhone())).toList();
    }
}
