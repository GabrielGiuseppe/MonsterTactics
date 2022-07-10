package com.questgames.monster.tactics.repository;

import com.questgames.monster.tactics.model.monster.Monster;
import org.springframework.data.repository.CrudRepository;

public interface MonsterRepository extends CrudRepository<Monster, Long> {
}
