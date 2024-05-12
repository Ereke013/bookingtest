package kz.iitu.bookinghotels.repositories;

import kz.iitu.bookinghotels.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
