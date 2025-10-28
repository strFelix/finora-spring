package br.com.strfelix.finora_spring.controller;

import br.com.strfelix.finora_spring.model.Transaction;
import br.com.strfelix.finora_spring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction createTransaction(
            @RequestBody Transaction transaction,
            @PathVariable Long userId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long localId,
            @RequestParam(required = false) Long recurrenceId) {

        return transactionService.createTransaction(transaction, userId, categoryId, localId, recurrenceId);
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> getUserTransactions(@PathVariable Long userId) {
        return transactionService.findTransactionsByUser(userId);
    }

    @GetMapping("/{idTransaction}")
    @ResponseStatus(HttpStatus.OK)
    public Transaction getTransactionById(@PathVariable Long idTransaction) {
        return transactionService.findTransactionById(idTransaction);
    }

    @PutMapping("/{idTransaction}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTransaction(@RequestBody Transaction transaction, @PathVariable Long idTransaction) {
        transactionService.updateTransaction(transaction, idTransaction);
    }

    @DeleteMapping("/{idTransaction}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTransaction(@PathVariable Long idTransaction) {
        transactionService.deleteTransaction(idTransaction);
    }
}
