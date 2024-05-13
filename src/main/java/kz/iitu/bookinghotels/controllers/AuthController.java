package kz.iitu.bookinghotels.controllers;


import kz.iitu.bookinghotels.entities.Guest;
import kz.iitu.bookinghotels.models.LoginDto;
import kz.iitu.bookinghotels.services.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private UserAuthService userAuthService;

    @GetMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        Guest guest = this.userAuthService.login(loginDto.getLogin(), loginDto.getPassword());
        if (guest == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(guest, HttpStatus.OK);
    }

}
