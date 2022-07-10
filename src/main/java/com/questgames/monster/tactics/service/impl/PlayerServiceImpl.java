package com.questgames.monster.tactics.service.impl;

import com.questgames.monster.tactics.mapper.PlayerMapper;
import com.questgames.monster.tactics.model.player.Player;
import com.questgames.monster.tactics.repository.PlayerRepository;
import com.questgames.monster.tactics.request.PlayerRequest;
import com.questgames.monster.tactics.response.PlayerResponse;
import com.questgames.monster.tactics.response.common.BaseReturn;
import com.questgames.monster.tactics.service.interfaces.PlayerService;
import com.questgames.monster.tactics.service.interfaces.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public BaseReturn<PlayerResponse> createNewPlayer(PlayerRequest request) {
        Player player = new Player();
        player.name = request.name;
        player.team = teamService.createNewTeam();
        player = playerRepository.save(player);
        PlayerResponse data = playerMapper.NewPlayerResponseMapping(player);
        BaseReturn<PlayerResponse> response = new BaseReturn<>(data);
        return response;
    }
}
