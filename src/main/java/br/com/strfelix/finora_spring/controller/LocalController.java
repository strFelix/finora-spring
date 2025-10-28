package br.com.strfelix.finora_spring.controller;

import br.com.strfelix.finora_spring.model.Local;
import br.com.strfelix.finora_spring.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locals")
public class LocalController {

    @Autowired
    private LocalService localService;

    @PostMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLocal(@RequestBody Local local, @PathVariable Long userId) {
        localService.createLocal(local, userId);
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Local> findLocalsByUser(@PathVariable Long userId) {
        return localService.findLocalsByUser(userId);
    }

    @GetMapping("/{localId}")
    @ResponseStatus(HttpStatus.OK)
    public Local findLocalById(@PathVariable Long localId) {
        return localService.findLocalById(localId);
    }

    @PutMapping("/{localId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLocal(@RequestBody Local local, @PathVariable Long localId) {
        localService.updateLocal(local, localId);
    }

    @DeleteMapping("/{localId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocal(@PathVariable Long localId) {
        localService.deleteLocal(localId);
    }
}
