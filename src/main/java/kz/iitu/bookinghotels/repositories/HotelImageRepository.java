package kz.iitu.bookinghotels.repositories;

import kz.iitu.bookinghotels.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface HotelImageRepository extends JpaRepository<Booking, Long> {
    @Query(value = "select image from hotel_image hi where hi.id != :hotel_id", nativeQuery = true)
    List<String> hotelImages(@Param("hotel_id") Long hotel_id);
}
