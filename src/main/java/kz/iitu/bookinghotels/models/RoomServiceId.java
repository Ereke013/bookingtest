package kz.iitu.bookinghotels.models;

import java.io.Serializable;
import java.util.Objects;

public class RoomServiceId implements Serializable {
    private Long services;
    private Long room;

    // Конструкторы
    public RoomServiceId() {}

    public RoomServiceId(Long services, Long room) {
        this.services = services;
        this.room = room;
    }

    // Геттеры и сеттеры
    public Long getServices() {
        return services;
    }

    public void setServices(Long services) {
        this.services = services;
    }

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long room) {
        this.room = room;
    }

    // equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomServiceId that = (RoomServiceId) o;
        return Objects.equals(services, that.services) && Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(services, room);
    }
}
