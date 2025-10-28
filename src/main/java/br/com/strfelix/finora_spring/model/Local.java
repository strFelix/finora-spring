package br.com.strfelix.finora_spring.model;

import br.com.strfelix.finora_spring.model.enums.LocalType;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_SGF_LOCAL")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_T_SGF_LOCAL")
    @SequenceGenerator(
            name = "SEQ_T_SGF_LOCAL",
            sequenceName = "SEQ_T_SGF_LOCAL",
            allocationSize = 1
    )
    @Column(name = "ID_LOCAL")
    private Long id;

    // N locais pertencem a 1 usuário
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private User user;

    @Column(name = "NM_LOCAL", nullable = false, length = 100)
    private String name;

    // CHAR(1) — ‘F’ (físico) ou ‘O’ (online)
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_LOCAL", nullable = false, length = 1)
    private LocalType type;

    @Column(name = "DS_ENDERECO", length = 200)
    private String address;

    @Column(name = "DS_CORDENADAS", length = 100)
    private String coordinates;

    @Column(name = "DT_ULTIMO_USO")
    private LocalDate lastUsed;

    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recurrence> recurrences = new ArrayList<>();

    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

    public Local() {}

    public Local(User user, String name, LocalType type, String address, String coordinates, LocalDate lastUsed) {
        this.user = user;
        this.name = name;
        this.type = type;
        this.address = address;
        this.coordinates = coordinates;
        this.lastUsed = lastUsed;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalType getType() { return type; }
    public void setType(LocalType type) { this.type = type; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCoordinates() { return coordinates; }
    public void setCoordinates(String coordinates) { this.coordinates = coordinates; }

    public LocalDate getLastUsed() { return lastUsed; }
    public void setLastUsed(LocalDate lastUsed) { this.lastUsed = lastUsed; }

    public void addRecurrence(Recurrence recurrence) {
        recurrences.add(recurrence);
        recurrence.setLocal(this);
    }

    public void removeRecurrence(Recurrence recurrence) {
        recurrences.remove(recurrence);
        recurrence.setLocal(null);
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
        t.setLocal(this);
    }

    public void removeTransaction(Transaction t) {
        transactions.remove(t);
        t.setLocal(null);
    }

    @Override
    public String toString() {
        return "Local{" +
                "id=" + id +
                ", userId=" + (user != null ? user.getId() : null) +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", lastUsed=" + lastUsed +
                '}';
    }
}
