package br.com.strfelix.finora_spring.service;

import br.com.strfelix.finora_spring.mapper.LocalMapper;
import br.com.strfelix.finora_spring.model.Local;
import br.com.strfelix.finora_spring.model.User;
import br.com.strfelix.finora_spring.repository.LocalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private LocalMapper localMapper;

    @Autowired
    private UserService userService;

    public void createLocal(Local local, Long userId) {
        User user = userService.FindUserById(userId);
        local.setUser(user);
        localRepository.save(local);
    }

    public List<Local> findLocalsByUser(Long userId) {
        return localRepository.findByUserId(userId);
    }

    public Local findLocalById(Long localId) {
        return localRepository.findById(localId)
                .orElseThrow(() -> new EntityNotFoundException("Local not found."));
    }

    public void updateLocal(Local local, Long localId) {
        Local existingLocal = findLocalById(localId);
        localMapper.updateLocalFromDto(local, existingLocal);
        localRepository.save(existingLocal);
    }

    public void deleteLocal(Long localId) {
        findLocalById(localId);
        localRepository.deleteById(localId);
    }
}
