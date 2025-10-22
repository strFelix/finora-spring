package br.com.strfelix.finora_spring.model;

import br.com.strfelix.finora_spring.model.enums.CategoryType;

import java.util.Arrays;

public class Category {
    private int id;
    private User user;
    private String description;
    private CategoryType type;
    private Byte[] icon;
    private String colorHex;
    private boolean isDefault;

    public Category() {}

    public Category(int id, User user, String description, CategoryType type, Byte[] icon, String colorHex, boolean isDefault) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.type = type;
        this.icon = icon;
        this.colorHex = colorHex;
        this.isDefault = isDefault;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    public Byte[] getIcon() {
        return icon;
    }

    public void setIcon(Byte[] icon) {
        this.icon = icon;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", icon=" + Arrays.toString(icon) +
                ", colorHex='" + colorHex + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }
}
