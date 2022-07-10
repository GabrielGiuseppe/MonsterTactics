package com.questgames.monster.tactics.mapper;

import com.questgames.monster.tactics.model.player.Player;
import com.questgames.monster.tactics.response.PlayerResponse;
import org.springframework.stereotype.Service;

@Service
public class PlayerMapper {
    public PlayerResponse NewPlayerResponseMapping(Player player) {
        PlayerResponse response = new PlayerResponse();
        response.playerId = player.uuid;
        response.teamId = player.team.uuid;
        return response;
    }
}
