package kz.iitu.bookinghotels.repositories;

import kz.iitu.bookinghotels.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByGuest_EmailAndAndGuest_Phone(String email, String phone);
}
