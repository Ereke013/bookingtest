package kz.iitu.bookinghotels.services;

import kz.iitu.bookinghotels.entities.Hotel;
import kz.iitu.bookinghotels.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }


    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public void deleteHotel(Hotel booking) {
        hotelRepository.delete(booking);
    }

    public List<Hotel> getAllList() {
        return hotelRepository.findAll();
    }
}
