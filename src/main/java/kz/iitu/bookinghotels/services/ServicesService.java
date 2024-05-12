package kz.iitu.bookinghotels.services;

import kz.iitu.bookinghotels.entities.Services;
import kz.iitu.bookinghotels.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService {

    @Autowired
    private ServiceRepository serviceRepository;

    public Services addServices(Services friend) {
        return serviceRepository.save(friend);
    }

    public Services getServicesById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public void deleteServices(Services booking) {
        serviceRepository.delete(booking);
    }

    public List<Services> getAllList() {
        return serviceRepository.findAll();
    }
}
