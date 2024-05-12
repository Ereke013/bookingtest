package kz.iitu.bookinghotels.entities;

import jakarta.persistence.*;
import kz.iitu.bookinghotels.models.RoomTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "room")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "room_types")
//    private RoomTypes room_types;

    @Column(name = "area")
    private Integer area;

    @Column(name = "base_price")
    private Integer base_price;

    @ManyToOne(fetch = FetchType.EAGER)
    private Hotel hotel;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_type")
    private RoomTypes room_type;
}
