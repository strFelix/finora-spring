package br.com.strfelix.finora_spring.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "T_SGF_RESUMO_MENSAL")
public class MensalResume {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_T_SGF_RESUMO_MENSAL")
    @SequenceGenerator(
            name = "SEQ_T_SGF_RESUMO_MENSAL",
            sequenceName = "SEQ_T_SGF_RESUMO_MENSAL",
            allocationSize = 1
    )
    @Column(name = "ID_RESUMO")
    private Long id;

    @Column(name = "REF_MES", nullable = false, length = 7)
    private String refMonth; // Exemplo: "01/2025"

    @Column(name = "TOTAL_ENTRADAS", nullable = false, precision = 10, scale = 2)
    private Double totalEntry;

    @Column(name = "TOTAL_SAIDAS", nullable = false, precision = 10, scale = 2)
    private Double totalExit;

    @Lob
    @Column(name = "DS_CATEGORIAS", columnDefinition = "CLOB")
    private String transactionsPerCategoryJson;

    @Transient
    private List<Transaction> transactionsPerCategory;

    public MensalResume() {}

    public MensalResume(String refMonth, Double totalEntry, Double totalExit, List<Transaction> transactionsPerCategory) {
        this.refMonth = refMonth;
        this.totalEntry = totalEntry;
        this.totalExit = totalExit;
        this.transactionsPerCategory = transactionsPerCategory;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRefMonth() { return refMonth; }
    public void setRefMonth(String refMonth) { this.refMonth = refMonth; }

    public Double getTotalEntry() { return totalEntry; }
    public void setTotalEntry(Double totalEntry) { this.totalEntry = totalEntry; }

    public Double getTotalExit() { return totalExit; }
    public void setTotalExit(Double totalExit) { this.totalExit = totalExit; }

    public String getTransactionsPerCategoryJson() { return transactionsPerCategoryJson; }
    public void setTransactionsPerCategoryJson(String transactionsPerCategoryJson) { this.transactionsPerCategoryJson = transactionsPerCategoryJson; }

    public List<Transaction> getTransactionsPerCategory() { return transactionsPerCategory; }
    public void setTransactionsPerCategory(List<Transaction> transactionsPerCategory) { this.transactionsPerCategory = transactionsPerCategory; }


    @PrePersist
    @PreUpdate
    private void serializeTransactions() throws JsonProcessingException {
        if (transactionsPerCategory != null) {
            ObjectMapper mapper = new ObjectMapper();
            this.transactionsPerCategoryJson = mapper.writeValueAsString(transactionsPerCategory);
        }
    }

    @PostLoad
    private void deserializeTransactions() throws JsonProcessingException {
        if (transactionsPerCategoryJson != null && !transactionsPerCategoryJson.isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();
            this.transactionsPerCategory = List.of(mapper.readValue(transactionsPerCategoryJson, Transaction[].class));
        }
    }

    @Override
    public String toString() {
        return "MensalResume{" +
                "id=" + id +
                ", refMonth='" + refMonth + '\'' +
                ", totalEntry=" + totalEntry +
                ", totalExit=" + totalExit +
                ", transactionsPerCategoryJson='" + transactionsPerCategoryJson + '\'' +
                '}';
    }
}
