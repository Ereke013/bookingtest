package kz.iitu.bookinghotels.repositories;

import kz.iitu.bookinghotels.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findAllByName(String hotelName);

//    @Query(value = "select * from t_users u where u.id != :id", nativeQuery = true)
//    List<Users> recommendFriends(@Param("id") Long id);
}
