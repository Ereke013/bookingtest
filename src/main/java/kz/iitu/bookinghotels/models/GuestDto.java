package kz.iitu.bookinghotels.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestDto {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private Role role;
}
