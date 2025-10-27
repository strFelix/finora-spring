package br.com.strfelix.finora_spring.model;

import br.com.strfelix.finora_spring.model.enums.TransactionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "T_SGF_TRANSACAO")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_T_SGF_TRANSACAO")
    @SequenceGenerator(
            name = "SEQ_T_SGF_TRANSACAO",
            sequenceName = "SEQ_T_SGF_TRANSACAO",
            allocationSize = 1
    )
    @Column(name = "ID_TRANSACAO")
    private Long id;

    // N transações pertencem a 1 usuário
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private User user;

    // FK opcional para categoria
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORIA")
    private Category category;

    // FK opcional para recorrência
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_RECORRENCIA")
    private Recurrence recurrence;

    // FK opcional para local
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_LOCAL")
    private Local local;

    @Column(name = "VL_TRANSACAO", precision = 10, scale = 2)
    private BigDecimal value;

    @Column(name = "DT_TRANSICAO", nullable = false)
    private LocalDate date;

    @Column(name = "DS_TRANSACAO", length = 150)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_TRANSACAO", nullable = false, length = 1)
    private TransactionType type;

    @Column(name = "PARCELA_TRANSACAO")
    private Integer installment;

    @Column(name = "TOTAL_PARCELAS")
    private Integer totalInstallments;

    @Column(name = "IS_RECORRENTE", nullable = false, length = 1)
    private String isRecurring; // 'S' ou 'N' (sim/não)

    public Transaction() {}

    public Transaction(User user, Category category, Recurrence recurrence, Local local,
                       BigDecimal value, LocalDate date, String description, TransactionType type,
                       Integer installment, Integer totalInstallments, boolean recurring) {
        this.user = user;
        this.category = category;
        this.recurrence = recurrence;
        this.local = local;
        this.value = value;
        this.date = date;
        this.description = description;
        this.type = type;
        this.installment = installment;
        this.totalInstallments = totalInstallments;
        this.isRecurring = recurring ? "S" : "N";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Recurrence getRecurrence() { return recurrence; }
    public void setRecurrence(Recurrence recurrence) { this.recurrence = recurrence; }

    public Local getLocal() { return local; }
    public void setLocal(Local local) { this.local = local; }

    public BigDecimal getValue() { return value; }
    public void setValue(BigDecimal value) { this.value = value; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public TransactionType getType() { return type; }
    public void setType(TransactionType type) { this.type = type; }

    public Integer getInstallment() { return installment; }
    public void setInstallment(Integer installment) { this.installment = installment; }

    public Integer getTotalInstallments() { return totalInstallments; }
    public void setTotalInstallments(Integer totalInstallments) { this.totalInstallments = totalInstallments; }

    public boolean isRecurring() { return "S".equalsIgnoreCase(isRecurring); }
    public void setRecurring(boolean recurring) { this.isRecurring = recurring ? "S" : "N"; }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", userId=" + (user != null ? user.getId() : null) +
                ", categoryId=" + (category != null ? category.getId() : null) +
                ", recurrenceId=" + (recurrence != null ? recurrence.getId() : null) +
                ", localId=" + (local != null ? local.getId() : null) +
                ", value=" + value +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", installment=" + installment +
                ", totalInstallments=" + totalInstallments +
                ", isRecurring=" + isRecurring +
                '}';
    }
}
