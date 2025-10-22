package br.com.strfelix.finora_spring.model;

import br.com.strfelix.finora_spring.model.enums.TransactionType;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private UUID id;
    private User user;
    private Category category;
    private Recurrence recurrence;
    private Local local;
    private double value;
    private LocalDateTime date;
    private String description;
    private TransactionType type;
    private int installment;
    private int quantityInstallments;
    private boolean isRecurring;

    public Transaction() {
    }

    public Transaction(User user, Category category, Local local,
                       double value, LocalDateTime date, String description, TransactionType type,
                       int installment, int quantityInstallments) {
        this.id = generateId();
        this.user = user;
        this.category = category;
        this.recurrence = null;
        this.local = local;
        this.value = value;
        this.date = date;
        this.description = description;
        this.type = type;
        this.installment = installment;
        this.quantityInstallments = quantityInstallments;
        this.isRecurring = false;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Recurrence getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(Recurrence recurrence) {
        this.recurrence = recurrence;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public int getInstallment() {
        return installment;
    }

    public void setInstallment(int installment) {
        this.installment = installment;
    }

    public int getQuantityInstallments() {
        return quantityInstallments;
    }

    public void setQuantityInstallments(int quantityInstallments) {
        this.quantityInstallments = quantityInstallments;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }

    private static UUID generateId() {
        //System.out.println("Transaction.generateId(): gerando ID da transação");
        return UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", user=" + user +
                ", category=" + category +
                ", recurrence=" + recurrence +
                ", local=" + local +
                ", value=" + value +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", installment=" + installment +
                ", quantityInstallments=" + quantityInstallments +
                ", isRecurring=" + isRecurring +
                '}';
    }
}
