package kz.iitu.bookinghotels.services;

import kz.iitu.bookinghotels.entities.Entertainment;
import kz.iitu.bookinghotels.repositories.EntertainmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntertainmentService {

    @Autowired
    private EntertainmentRepository entertainmentRepository;

    public Entertainment saveEntertainment(Entertainment friend) {
        return entertainmentRepository.save(friend);
    }

    public Entertainment getEntertainmentById(Long id) {
        return entertainmentRepository.findById(id).orElse(null);
    }

    public void deleteEntertainment(Entertainment booking) {
        entertainmentRepository.delete(booking);
    }

    public List<Entertainment> getAllList() {
        return entertainmentRepository.findAll();
    }
}
