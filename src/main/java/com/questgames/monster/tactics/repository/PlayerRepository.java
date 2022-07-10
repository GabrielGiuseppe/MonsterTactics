package com.questgames.monster.tactics.repository;

import com.questgames.monster.tactics.model.player.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
