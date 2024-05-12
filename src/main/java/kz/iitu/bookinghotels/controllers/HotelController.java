package kz.iitu.bookinghotels.controllers;


import kz.iitu.bookinghotels.entities.Hotel;
import kz.iitu.bookinghotels.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllHotels() {
        return new ResponseEntity<>(this.hotelService.getAllList(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable(name = "id") Long id) {
        Hotel hotel = this.hotelService.getHotelById(id);
        if (hotel != null) {
            return ResponseEntity.ok(hotel);
        }
        return null;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateHotel(@RequestBody Hotel hotel, @PathVariable(name = "id") Long id) {
        Hotel hotel1 = this.hotelService.getHotelById(id);
        if (hotel1 != null) {
            hotel1.setName(hotel.getName());
            hotel1.setImage(hotel.getImage());
            hotel1.setStar(hotel.getStar());
            hotel1.setLocation(hotel.getLocation());
            hotel1.setNum_of_floor(hotel.getNum_of_floor());
            hotel1.setNum_of_rooms(hotel.getNum_of_rooms());

            this.hotelService.updateHotel(hotel1);
        }

        return ResponseEntity.ok(hotel1);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteHotelById(@PathVariable(name = "id") Long id) {
        Hotel hotel = this.hotelService.getHotelById(id);
        if (hotel != null) {
            this.hotelService.deleteHotel(hotel);
            return ResponseEntity.ok(hotel);
        }
        return null;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addHotel(@RequestBody Hotel hotel) {
        if (hotel != null) {
            this.hotelService.addHotel(hotel);
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        }
        return null;
    }
}
