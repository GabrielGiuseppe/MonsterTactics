package com.questgames.monster.tactics.mapper;

import com.questgames.monster.tactics.model.monster.Monster;
import com.questgames.monster.tactics.response.EncounterResponse;
import com.questgames.monster.tactics.response.common.AttributesResponse;
import org.springframework.stereotype.Service;

@Service
public class EncounterMapper {


    public EncounterResponse encounterResponseMapping(Monster monster) {
        EncounterResponse encounterResponse = new EncounterResponse();
        encounterResponse.race = monster.monsterRace.name;
        encounterResponse.attributes = mapAttributes(monster);
        encounterResponse.monsterId = monster.uuid;
        return encounterResponse;
    }

    private AttributesResponse mapAttributes(Monster monster) {
        AttributesResponse response = new AttributesResponse();
        response.str = monster.str;
        response.agi = monster.agi;
        response.con = monster.con;
        response.inte = monster.inte;
        response.dex = monster.dex;
        response.luk = monster.luk;
        return response;
    }
}
