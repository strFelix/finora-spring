package br.com.strfelix.finora_spring.repository;

import br.com.strfelix.finora_spring.model.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long> {
    List<Local> findByUserId(Long userId);
}
