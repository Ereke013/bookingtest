package kz.iitu.bookinghotels.services;

import kz.iitu.bookinghotels.entities.Guest;
import kz.iitu.bookinghotels.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {
    @Autowired
    private GuestRepository guestRepository;

//    public Guest login(String login, String password) {
//        return this.guestRepository.findByLoginAndPassword(login, password);
//    }
}
