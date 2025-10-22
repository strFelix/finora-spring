package br.com.strfelix.finora_spring.model;

public class Preferences {
    private int id;
    private String preferences;

    public Preferences() {
    }

    public Preferences(int id, String preferences) {
        this.id = id;
        this.preferences = preferences;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
}
