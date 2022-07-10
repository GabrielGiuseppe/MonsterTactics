package com.questgames.monster.tactics.mapper;

import com.questgames.monster.tactics.model.monster.MonsterElementType;
import com.questgames.monster.tactics.model.monster.MonsterRace;
import com.questgames.monster.tactics.request.MonsterRaceRequest;
import com.questgames.monster.tactics.response.MonsterRaceResponse;
import org.springframework.stereotype.Service;

@Service
public class MonsterRaceMapper {
    public MonsterRace create(MonsterRaceRequest request, MonsterElementType monsterElementType) {
        MonsterRace monsterRace = new MonsterRace();
        monsterRace.name = request.name;
        monsterRace.monsterElementType = monsterElementType;
        return monsterRace;
    }

    public MonsterRaceResponse response(MonsterRace monsterRace) {
        MonsterRaceResponse response = new MonsterRaceResponse();
        response.name = monsterRace.name;
        response.uuid = monsterRace.uuid;
        response.element = monsterRace.monsterElementType.name;
        return response;
    }
}
