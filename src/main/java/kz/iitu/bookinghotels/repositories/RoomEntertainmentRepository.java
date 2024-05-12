package kz.iitu.bookinghotels.repositories;

import kz.iitu.bookinghotels.entities.RoomEntertainment;
import kz.iitu.bookinghotels.models.RoomEntertainmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoomEntertainmentRepository extends JpaRepository<RoomEntertainment, RoomEntertainmentId> {

}
