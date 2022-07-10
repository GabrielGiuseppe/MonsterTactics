package com.questgames.monster.tactics.repository;

import com.questgames.monster.tactics.model.monster.MonsterRace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonsterRaceRepository extends CrudRepository<MonsterRace, Long> {

    Optional<MonsterRace> findById(Long id);
}
