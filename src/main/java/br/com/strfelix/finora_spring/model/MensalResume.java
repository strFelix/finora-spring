package br.com.strfelix.finora_spring.model;

import java.util.List;

public class MensalResume {
    private int id;
    private String refMonth;
    private double totalEntry;
    private double totalExit;
    private List<Transaction> transactionsPerCategory;

    public MensalResume() {
    }

    public MensalResume(int id, String refMonth, double totalEntry, double totalExit, List<Transaction> transactionsPerCategory) {
        this.id = id;
        this.refMonth = refMonth;
        this.totalEntry = totalEntry;
        this.totalExit = totalExit;
        this.transactionsPerCategory = transactionsPerCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefMonth() {
        return refMonth;
    }

    public void setRefMonth(String refMonth) {
        this.refMonth = refMonth;
    }

    public double getTotalEntry() {
        return totalEntry;
    }

    public void setTotalEntry(double totalEntry) {
        this.totalEntry = totalEntry;
    }

    public double getTotalExit() {
        return totalExit;
    }

    public void setTotalExit(double totalExit) {
        this.totalExit = totalExit;
    }

    public List<Transaction> getTransactionsPerCategory() {
        return transactionsPerCategory;
    }

    public void setTransactionsPerCategory(List<Transaction> transactionsPerCategory) {
        this.transactionsPerCategory = transactionsPerCategory;
    }

    @Override
    public String toString() {
        return "MensalResume{" +
                "id=" + id +
                ", refMonth='" + refMonth + '\'' +
                ", totalEntry=" + totalEntry +
                ", totalExit=" + totalExit +
                ", transactionsPerCategory=" + transactionsPerCategory +
                '}';
    }
}
