package kz.iitu.bookinghotels.repositories;

import kz.iitu.bookinghotels.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GuestRepository extends JpaRepository<Guest, Long> {
    Guest findByEmail(String email);
}
