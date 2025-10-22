package br.com.strfelix.finora_spring.model;

import java.time.LocalDateTime;

public class Goal {
    private int id;
    private User user;
    private Category category;
    private String title;
    private String description;
    private double targetValue;
    private double currentValue;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String goalType;
    private String notificationConfig;

    public Goal() {}

    public Goal(int id, User user, Category category, String title, String description,
                double targetValue, double currentValue, LocalDateTime startDate,
                LocalDateTime endDate, String goalType, String notificationConfig) {
        this.id = id;
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

    public double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(double targetValue) {
        this.targetValue = targetValue;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public String getNotificationConfig() {
        return notificationConfig;
    }

    public void setNotificationConfig(String notificationConfig) {
        this.notificationConfig = notificationConfig;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", user=" + user +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", targetValue=" + targetValue +
                ", currentValue=" + currentValue +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", goalType='" + goalType + '\'' +
                ", notificationConfig='" + notificationConfig + '\'' +
                '}';
    }
}
