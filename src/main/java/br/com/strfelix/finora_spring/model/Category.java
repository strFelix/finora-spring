package br.com.strfelix.finora_spring.model;

import br.com.strfelix.finora_spring.Utils.BooleanToCharConverter;
import br.com.strfelix.finora_spring.model.enums.CategoryType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_SGF_CATEGORIA")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_T_SGF_CATEGORIA")
    @SequenceGenerator(
            name = "SEQ_T_SGF_CATEGORIA",
            sequenceName = "SEQ_T_SGF_CATEGORIA",
            allocationSize = 1
    )
    @Column(name = "ID_CATEGORIA")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private User user;

    @Column(name = "NM_CATEGORIA", nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_CATEGORIA", nullable = false, length = 30)
    private CategoryType type;

    @Column(name = "ICONE_CATEGORIA", length = 30)
    private String icon;

    @Column(name = "COR_HEX", length = 7)
    private String colorHex;

    @Column(name = "IS_PADRAO", nullable = false, length = 1)
    @Convert(converter = BooleanToCharConverter.class)
    private boolean isDefault;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Goal> goals = new ArrayList<>();

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recurrence> recurrences = new ArrayList<>();

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

    public Category() {}

    public Category(User user, String name, CategoryType type, String icon, String colorHex, Boolean isDefault) {
        this.user = user;
        this.name = name;
        this.type = type;
        this.icon = icon;
        this.colorHex = colorHex;
        this.isDefault = isDefault;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CategoryType getType() { return type; }
    public void setType(CategoryType type) { this.type = type; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public String getColorHex() { return colorHex; }
    public void setColorHex(String colorHex) { this.colorHex = colorHex; }

    public Boolean getIsDefault() { return isDefault; }
    public void setIsDefault(Boolean isDefault) { this.isDefault = isDefault; }

    public void addGoal(Goal goal) {
        goals.add(goal);
        goal.setCategory(this);
    }

    public void removeGoal(Goal goal) {
        goals.remove(goal);
        goal.setCategory(null);
    }

    public void addRecurrence(Recurrence recurrence) {
        recurrences.add(recurrence);
        recurrence.setCategory(this);
    }

    public void removeRecurrence(Recurrence recurrence) {
        recurrences.remove(recurrence);
        recurrence.setCategory(null);
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
        t.setCategory(this);
    }

    public void removeTransaction(Transaction t) {
        transactions.remove(t);
        t.setCategory(null);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", userId=" + (user != null ? user.getId() : null) +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", icon='" + icon + '\'' +
                ", colorHex='" + colorHex + '\'' +
                ", isDefault='" + isDefault + '\'' +
                '}';
    }
}
