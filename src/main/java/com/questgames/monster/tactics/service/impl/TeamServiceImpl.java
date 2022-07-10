package com.questgames.monster.tactics.service.impl;

import com.questgames.monster.tactics.model.player.Team;
import com.questgames.monster.tactics.repository.TeamRepository;
import com.questgames.monster.tactics.service.interfaces.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamRepository repository;

    @Override
    public Team createNewTeam() {
        Team team = new Team();
        return team;
    }
}
