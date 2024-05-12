package kz.iitu.bookinghotels.entities;

import jakarta.persistence.*;
import kz.iitu.bookinghotels.models.RoomServiceId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "room_service")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(RoomServiceId.class)
public class RoomService {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Services services;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @Column(name = "cost")
    private Integer cost;
}
