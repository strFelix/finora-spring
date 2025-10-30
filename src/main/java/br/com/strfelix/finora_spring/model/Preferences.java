package br.com.strfelix.finora_spring.model;

import jakarta.persistence.Transient;

public class Preferences {
    @Transient
    private boolean darkMode;

    @Transient
    private String language;

    @Transient
    private String currency;

    @Transient
    private int itemsPerPage;

    @Transient
    private boolean emailNotifications;

    @Transient
    private byte[] avatar;

    public Preferences() {
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public String getLanguage() {
        return language;
    }

    public String getCurrency() {
        return currency;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public boolean isEmailNotifications() {
        return emailNotifications;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
}
