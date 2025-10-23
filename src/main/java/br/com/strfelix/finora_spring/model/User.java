package br.com.strfelix.finora_spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_SGF_USUARIO")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_T_SGF_USUARIO")
    @SequenceGenerator(
            name = "SEQ_T_SGF_USUARIO",
            sequenceName = "SEQ_T_SGF_USUARIO",
            allocationSize = 1
    )
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "NM_USUARIO", nullable = false, length = 100)
    private String name;

    @Column(name = "EMAIL_USUARIO", nullable = false, length = 100, unique = true)
    private String email;

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String plainPassword;

    @Column(name = "SENHA_HASH", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "DT_CADASTRO", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "DT_ULTIMO_LOGIN")
    private LocalDateTime lastLoginDate;

    @Column(name = "PREF_USUARIO", columnDefinition = "CLOB")
    private String preferencesJson;


    public User() {
    }

    // getters e setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }

    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public LocalDateTime getCreationDate() { return creationDate; }

    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }

    public LocalDateTime getLastLoginDate() { return lastLoginDate; }

    public void setLastLoginDate(LocalDateTime lastLoginDate) { this.lastLoginDate = lastLoginDate; }

    public String getPreferencesJson() { return preferencesJson; }

    public void setPreferencesJson(String preferencesJson) { this.preferencesJson = preferencesJson; }

    public String getPlainPassword() { return plainPassword; }

    public void setPlainPassword(String plainPassword) { this.plainPassword = plainPassword; }

    @PrePersist
    private void onCreate() {
        this.creationDate = LocalDateTime.now();
        if (this.preferencesJson == null)
            this.preferencesJson = "{}";
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", creationDate=" + creationDate +
                ", lastLoginDate=" + lastLoginDate +
                '}';
    }
}
