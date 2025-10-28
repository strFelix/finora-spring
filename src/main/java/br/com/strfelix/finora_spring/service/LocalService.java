package br.com.strfelix.finora_spring.service;

import br.com.strfelix.finora_spring.mapper.LocalMapper;
import br.com.strfelix.finora_spring.model.Goal;
import br.com.strfelix.finora_spring.model.Local;
import br.com.strfelix.finora_spring.model.User;
import br.com.strfelix.finora_spring.repository.LocalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Local findLocalById(Long id) {
        Optional<Local> optionalLocal = localRepository.findById(id);
        if (optionalLocal.isPresent()) {
            return optionalLocal.get();
        } else {
            throw new EntityNotFoundException("Local not found.");
        }
    }

    public void updateLocal(Local local) {
        Local existingLocal = findLocalById(local.getId());
        localMapper.updateGoalFromDto(local, existingLocal);
        localRepository.save(existingLocal);
    }

    public void deleteLocal(Long id) {
        findLocalById(id);
        localRepository.deleteById(id);
    }
}
