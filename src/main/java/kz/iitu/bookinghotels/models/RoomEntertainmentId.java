package kz.iitu.bookinghotels.models;

import java.io.Serializable;
import java.util.Objects;

public class RoomEntertainmentId implements Serializable {
    private Long entertainment;
    private Long room;

    // Конструкторы
    public RoomEntertainmentId() {
    }

    public RoomEntertainmentId(Long entertainment, Long room) {
        this.entertainment = entertainment;
        this.room = room;
    }

    // Геттеры и сеттеры
    public Long getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(Long entertainment) {
        this.entertainment = entertainment;
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
        RoomEntertainmentId that = (RoomEntertainmentId) o;
        return Objects.equals(entertainment, that.entertainment) && Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entertainment, room);
    }
}
