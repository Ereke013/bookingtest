package kz.iitu.bookinghotels.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "star")
    private Integer star;

    @Column(name = "image")
    private String image;

    @Column(name = "num_of_floor")
    private Integer num_of_floor;

    @Column(name = "num_of_rooms")
    private Integer num_of_rooms;
}
