package kz.iitu.bookinghotels.repositories;

import kz.iitu.bookinghotels.entities.RoomService;
import kz.iitu.bookinghotels.models.RoomServiceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoomServiceRepository extends JpaRepository<RoomService, RoomServiceId> {

}
