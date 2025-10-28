package br.com.strfelix.finora_spring.service;

import br.com.strfelix.finora_spring.model.*;
import br.com.strfelix.finora_spring.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RecurrenceRepository recurrenceRepository;

    @Autowired
    private LocalRepository localRepository;

    public Transaction createTransaction(Transaction transaction, Long userId, Long categoryId,
                                         Long localId, Long recurrenceId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
        transaction.setUser(user);

        if (categoryId != null) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new EntityNotFoundException("Category not found."));
            transaction.setCategory(category);
        }

        if (localId != null) {
            Local local = localRepository.findById(localId)
                    .orElseThrow(() -> new EntityNotFoundException("Local not found."));
            transaction.setLocal(local);
        }

        if (recurrenceId != null) {
            Recurrence recurrence = recurrenceRepository.findById(recurrenceId)
                    .orElseThrow(() -> new EntityNotFoundException("Recurrence not found."));
            transaction.setRecurrence(recurrence);
        }

        return transactionRepository.save(transaction);
    }

    public List<Transaction> findTransactionsByUser(Long userId) {
        List<Transaction> transactions = transactionRepository.findByUserId(userId);
        if (transactions.isEmpty())
            throw new EntityNotFoundException("No transactions found for user ID: " + userId);
        return transactions;
    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found."));
    }

    public void updateTransaction(Transaction transaction) {
        Optional<Transaction> optional = transactionRepository.findById(transaction.getId());
        if (optional.isEmpty()) {
            throw new EntityNotFoundException("Transaction not found.");
        }

        Transaction existing = optional.get();

        if (transaction.getValue().compareTo(BigDecimal.ZERO) > 0)
            existing.setValue(transaction.getValue());
        if (transaction.getDescription() != null)
            existing.setDescription(transaction.getDescription());
        if (transaction.getType() != null)
            existing.setType(transaction.getType());
        if (transaction.getDate() != null)
            existing.setDate(transaction.getDate());
        if (transaction.getInstallment() != null)
            existing.setInstallment(transaction.getInstallment());
        if (transaction.getTotalInstallments() != null)
            existing.setTotalInstallments(transaction.getTotalInstallments());
        existing.setRecurring(transaction.isRecurring());

        transactionRepository.save(existing);
    }

    public void deleteTransaction(Long id) {
        findById(id);
        transactionRepository.deleteById(id);
    }
}
