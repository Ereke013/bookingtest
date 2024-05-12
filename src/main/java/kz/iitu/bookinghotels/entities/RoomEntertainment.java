package kz.iitu.bookinghotels.entities;

import jakarta.persistence.*;
import kz.iitu.bookinghotels.models.RoomEntertainmentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "room_entertainment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(RoomEntertainmentId.class)
public class RoomEntertainment {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entertainment_id", referencedColumnName = "id")
    private Entertainment entertainment;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    @Column(name = "cost")
    private Integer cost;
}
