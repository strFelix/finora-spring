package br.com.strfelix.finora_spring.model;

import br.com.strfelix.finora_spring.model.enums.Frequency;
import br.com.strfelix.finora_spring.model.enums.RecurrenceType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_SGF_RECORRENCIA")
public class Recurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_T_SGF_RECORRENCIA")
    @SequenceGenerator(
            name = "SEQ_T_SGF_RECORRENCIA",
            sequenceName = "SEQ_T_SGF_RECORRENCIA",
            allocationSize = 1
    )
    @Column(name = "ID_RECORRENCIA")
    private Long id;

    // N recorrências pertencem a 1 usuário
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private User user;

    // FK opcional para categoria
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORIA")
    private Category category;

    // FK opcional para local
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_LOCAL")
    private Local local;

    @Column(name = "TITULO_RECORRENCIA", nullable = false, length = 50, unique = true)
    private String title;

    @Column(name = "DS_RECORRENCIA", length = 100)
    private String description;

    @Column(name = "VL_RECORRENTE", precision = 10, scale = 2)
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_RECORRENCIA", nullable = false, length = 20)
    private RecurrenceType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "FREQ_RECORRENCIA", nullable = false, length = 1)
    private Frequency frequency;

    @Column(name = "DT_REFERENCIA")
    private LocalDate refDate;

    @Column(name = "TOTAL_OCORRENCIAS")
    private Integer totalOccurrences;

    @Column(name = "OCORRENCIAS_RESTANTES")
    private Integer remainingOccurrences;

    @OneToMany(mappedBy = "recurrence", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

    public Recurrence() {}

    public Recurrence(User user, Category category, Local local, String title, String description,
                      BigDecimal value, RecurrenceType type, Frequency frequency, LocalDate refDate,
                      Integer totalOccurrences, Integer remainingOccurrences) {
        this.user = user;
        this.category = category;
        this.local = local;
        this.title = title;
        this.description = description;
        this.value = value;
        this.type = type;
        this.frequency = frequency;
        this.refDate = refDate;
        this.totalOccurrences = totalOccurrences;
        this.remainingOccurrences = remainingOccurrences;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Local getLocal() { return local; }
    public void setLocal(Local local) { this.local = local; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getValue() { return value; }
    public void setValue(BigDecimal value) { this.value = value; }

    public RecurrenceType getType() { return type; }
    public void setType(RecurrenceType type) { this.type = type; }

    public Frequency getFrequency() { return frequency; }
    public void setFrequency(Frequency frequency) { this.frequency = frequency; }

    public LocalDate getRefDate() { return refDate; }
    public void setRefDate(LocalDate refDate) { this.refDate = refDate; }

    public Integer getTotalOccurrences() { return totalOccurrences; }
    public void setTotalOccurrences(Integer totalOccurrences) { this.totalOccurrences = totalOccurrences; }

    public Integer getRemainingOccurrences() { return remainingOccurrences; }
    public void setRemainingOccurrences(Integer remainingOccurrences) { this.remainingOccurrences = remainingOccurrences; }

    public void addTransaction(Transaction t) {
        transactions.add(t);
        t.setRecurrence(this);
    }

    public void removeTransaction(Transaction t) {
        transactions.remove(t);
        t.setRecurrence(null);
    }

    @Override
    public String toString() {
        return "Recurrence{" +
                "id=" + id +
                ", userId=" + (user != null ? user.getId() : null) +
                ", categoryId=" + (category != null ? category.getId() : null) +
                ", localId=" + (local != null ? local.getId() : null) +
                ", title='" + title + '\'' +
                ", value=" + value +
                ", type=" + type +
                ", frequency=" + frequency +
                ", refDate=" + refDate +
                ", totalOccurrences=" + totalOccurrences +
                ", remainingOccurrences=" + remainingOccurrences +
                '}';
    }
}
