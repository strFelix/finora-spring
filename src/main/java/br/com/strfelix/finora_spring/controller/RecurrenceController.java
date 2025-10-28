package br.com.strfelix.finora_spring.controller;

import br.com.strfelix.finora_spring.model.Recurrence;
import br.com.strfelix.finora_spring.service.RecurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recurrences")
public class RecurrenceController {

    @Autowired
    private RecurrenceService recurrenceService;

    @PostMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRecurrence(
            @RequestBody Recurrence recurrence,
            @PathVariable Long userId,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long localId
    ) {
        recurrenceService.createRecurrence(recurrence, userId, categoryId, localId);
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Recurrence> findByUser(@PathVariable Long userId) {
        return recurrenceService.findByUser(userId);
    }

    @GetMapping("/{recurrenceId}")
    @ResponseStatus(HttpStatus.OK)
    public Recurrence findById(@PathVariable Long recurrenceId) {
        return recurrenceService.findRecurrenceById(recurrenceId);
    }

    @PutMapping("/{recurrenceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRecurrence(@RequestBody Recurrence recurrence, @PathVariable Long recurrenceId) {
        recurrenceService.updateRecurrence(recurrence, recurrenceId);
    }

    @DeleteMapping("/{recurrenceId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRecurrence(@PathVariable Long recurrenceId) {
        recurrenceService.deleteRecurrence(recurrenceId);
    }
}
