package com.questgames.monster.tactics.repository;

import com.questgames.monster.tactics.model.player.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByUuid(String uuid);
}
