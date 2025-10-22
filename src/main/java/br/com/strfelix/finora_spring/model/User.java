package br.com.strfelix.finora_spring.model;

import java.time.LocalDateTime;

public class User {
    private int id;
    private String name;
    private String email;
    private String passwordHash;
    private String passwordSalt;
    private LocalDateTime creationDate;
    private LocalDateTime lastLoginDate;
    private boolean active;
    private Preferences preferences;

    public User() {
    }

    public User(int id, String name, String email, String plainPassword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordSalt = generateSalt();
        this.passwordHash = hashPassword(plainPassword, this.passwordSalt);
        this.creationDate = LocalDateTime.now();
        this.lastLoginDate = null;
        this.active = true;
        this.preferences = new Preferences();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    private static String generateSalt() {
//        System.out.println("User.generateSalt(): gerando salt da senha");
        return "salt";
    }

    private static String hashPassword(String password, String salt) {
//        System.out.println("User.hashPassword(): gerando hash da senha");
        return "hash";
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", passwordSalt='" + passwordSalt + '\'' +
                ", creationDate=" + creationDate +
                ", lastLoginDate=" + lastLoginDate +
                ", active=" + active +
                ", preferences=" + preferences +
                '}';
    }
}
