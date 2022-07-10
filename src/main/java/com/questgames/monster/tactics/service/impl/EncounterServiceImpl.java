package com.questgames.monster.tactics.service.impl;

import com.questgames.monster.tactics.mapper.EncounterMapper;
import com.questgames.monster.tactics.model.monster.Monster;
import com.questgames.monster.tactics.response.EncounterResponse;
import com.questgames.monster.tactics.response.common.BaseReturn;
import com.questgames.monster.tactics.service.interfaces.EncounterService;
import com.questgames.monster.tactics.service.interfaces.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncounterServiceImpl implements EncounterService {

    @Autowired
    MonsterService monsterService;

    @Autowired
    EncounterMapper encounterMapper;

    @Override
    public BaseReturn<EncounterResponse> generateEncounter() {
        Monster monster = monsterService.generateNewMonster();
        EncounterResponse data = encounterMapper.encounterResponseMapping(monster);
        BaseReturn<EncounterResponse> response = new BaseReturn<>(data);
        return response;
    }
}
