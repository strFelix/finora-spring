package br.com.strfelix.finora_spring.model;

import br.com.strfelix.finora_spring.model.enums.Frequency;
import br.com.strfelix.finora_spring.model.enums.RecurrenceType;
import java.time.LocalDate;

public class Recurrence {
    private int id;
    private User user;
    private Category category;
    private Local local;
    private String title;
    private String description;
    private double value;
    private RecurrenceType type;
    private Frequency frequency;
    private LocalDate refDate;
    private int totalOccurrences;
    private int remainingOccurrences;

    public Recurrence() {
    }

    public Recurrence(int id, User user, Category category, Local local, String title, String description,
                      double value, RecurrenceType type, Frequency frequency, LocalDate refDate,
                      int totalOccurrences, int remainingOccurrences) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public RecurrenceType getType() {
        return type;
    }

    public void setType(RecurrenceType type) {
        this.type = type;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public LocalDate getRefDate() {
        return refDate;
    }

    public void setRefDate(LocalDate refDate) {
        this.refDate = refDate;
    }

    public int getTotalOccurrences() {
        return totalOccurrences;
    }

    public void setTotalOccurrences(int totalOccurrences) {
        this.totalOccurrences = totalOccurrences;
    }

    public int getRemainingOccurrences() {
        return remainingOccurrences;
    }

    public void setRemainingOccurrences(int remainingOccurrences) {
        this.remainingOccurrences = remainingOccurrences;
    }

    @Override
    public String toString() {
        return "Recurrence{" +
                "id=" + id +
                ", user=" + user +
                ", category=" + category +
                ", local=" + local +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", type=" + type +
                ", frequency=" + frequency +
                ", refDate=" + refDate +
                ", totalOccurrences=" + totalOccurrences +
                ", remainingOccurrences=" + remainingOccurrences +
                '}';
    }
}
