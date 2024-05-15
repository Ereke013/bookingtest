package kz.iitu.bookinghotels.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingGuestDto {
    private String email;
    private String phone;
}
