package br.com.strfelix.finora_spring.model;

import br.com.strfelix.finora_spring.model.enums.GoalType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "T_SGF_META")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_T_SGF_META")
    @SequenceGenerator(
            name = "SEQ_T_SGF_META",
            sequenceName = "SEQ_T_SGF_META",
            allocationSize = 1
    )
    @Column(name = "ID_META")
    private Long id;

    // N metas pertencem a 1 usuário
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private User user;

    // Meta pode estar vinculada a uma categoria
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORIA")
    private Category category;

    @Column(name = "TITULO_META", nullable = false, length = 100, unique = true)
    private String title;

    @Column(name = "DS_META", length = 255)
    private String description;

    @Column(name = "VL_ALVO", precision = 10, scale = 2)
    private BigDecimal targetValue;

    @Column(name = "VL_ATUAL", precision = 10, scale = 2)
    private BigDecimal currentValue;

    @Column(name = "DT_INICIO", nullable = false)
    private LocalDate startDate;

    @Column(name = "DT_LIMITE", nullable = false)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_META", nullable = false, length = 1)
    private GoalType goalType;

    @Lob
    @Column(name = "NOTIFICACAO_CONFIG", columnDefinition = "CLOB")
    private String notificationConfig;

    public Goal() {}

    public Goal(User user, Category category, String title, String description,
                BigDecimal targetValue, BigDecimal currentValue, LocalDate startDate,
                LocalDate endDate, GoalType goalType, String notificationConfig) {
        this.user = user;
        this.category = category;
        this.title = title;
        this.description = description;
        this.targetValue = targetValue;
        this.currentValue = currentValue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.goalType = goalType;
        this.notificationConfig = notificationConfig;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getTargetValue() { return targetValue; }
    public void setTargetValue(BigDecimal targetValue) { this.targetValue = targetValue; }

    public BigDecimal getCurrentValue() { return currentValue; }
    public void setCurrentValue(BigDecimal currentValue) { this.currentValue = currentValue; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public GoalType getGoalType() { return goalType; }
    public void setGoalType(GoalType goalType) { this.goalType = goalType; }

    public String getNotificationConfig() { return notificationConfig; }
    public void setNotificationConfig(String notificationConfig) { this.notificationConfig = notificationConfig; }

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", userId=" + (user != null ? user.getId() : null) +
                ", categoryId=" + (category != null ? category.getId() : null) +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", targetValue=" + targetValue +
                ", currentValue=" + currentValue +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", goalType='" + goalType + '\'' +
                '}';
    }
}
