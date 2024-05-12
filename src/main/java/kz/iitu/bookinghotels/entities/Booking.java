package kz.iitu.bookinghotels.entities;

import jakarta.persistence.*;
import kz.iitu.bookinghotels.models.RoomTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "check_in_date")
    private Date check_in_date;

    @Column(name = "check_out_date")
    private Date check_out_date;

    @Column(name = "total_costs")
    private Integer total_costs;

    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    private Guest guest;
}
