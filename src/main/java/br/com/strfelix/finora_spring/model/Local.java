package br.com.strfelix.finora_spring.model;

import java.time.LocalDateTime;

public class Local {
    private int id;
    private User user;
    private String name;
    private String type;
    private String address;
    private String coordinates;
    private LocalDateTime lastUsed;

    public Local() {}

    public Local(int id, User user, String name, String type, String address, String coordinates, LocalDateTime lastUsed) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.type = type;
        this.address = address;
        this.coordinates = coordinates;
        this.lastUsed = lastUsed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(LocalDateTime lastUsed) {
        this.lastUsed = lastUsed;
    }

    @Override
    public String toString() {
        return "Local{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", lastUsed=" + lastUsed +
                '}';
    }
}
