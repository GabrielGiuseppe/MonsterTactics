package com.questgames.monster.tactics.repository;

import com.questgames.monster.tactics.model.monster.MonsterElementType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonsterElementTypeRepository extends CrudRepository<MonsterElementType, Long> {

    List<MonsterElementType> findAll();

    MonsterElementType findByUuid(String uuid);
}
