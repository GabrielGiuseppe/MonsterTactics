package com.questgames.monster.tactics.service.impl;

import com.questgames.monster.tactics.model.monster.Monster;
import com.questgames.monster.tactics.repository.MonsterRaceRepository;
import com.questgames.monster.tactics.repository.MonsterRepository;
import com.questgames.monster.tactics.repository.TeamRepository;
import com.questgames.monster.tactics.service.interfaces.MonsterService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Random;

@Service
public class MonsterServiceImpl implements MonsterService {

    @Autowired
    private MonsterRaceRepository monsterRaceRepository;
    @Autowired
    private MonsterRepository monsterRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Monster generateNewMonster() {
        Monster monster = new Monster();
        monster = generateMonsterRace(monster);
        monster = generateAttributes(monster);
        monster.team = teamRepository.findByUuid("1");
        monster.name = monster.monsterRace.name;
        monster = monsterRepository.save(monster);
        return monster;
    }

    private Monster generateMonsterRace(Monster monster) {
        monster.monsterRace = monsterRaceRepository.findById(1L).get();
        return monster;
    }

    @SneakyThrows
    private Monster generateAttributes(Monster monster) {
        Field[] fields = monster.getClass().getDeclaredFields();
        for(Field field : fields){
            if(getAttributesFields(field)){
                field.set(monster,new Random().nextInt(10)+1);
            }
        }
        return monster;
    }

    private boolean getAttributesFields(Field field) {
        return field.getName().equals("str") ||
                field.getName().equals("agi") ||
                field.getName().equals("con") ||
                field.getName().equals("inte") ||
                field.getName().equals("dex") ||
                field.getName().equals("luk");
    }
}
