package com.questgames.monster.tactics.service.impl;

import com.questgames.monster.tactics.mapper.MonsterRaceMapper;
import com.questgames.monster.tactics.model.monster.MonsterElementType;
import com.questgames.monster.tactics.model.monster.MonsterRace;
import com.questgames.monster.tactics.repository.MonsterElementTypeRepository;
import com.questgames.monster.tactics.repository.MonsterRaceRepository;
import com.questgames.monster.tactics.request.MonsterRaceRequest;
import com.questgames.monster.tactics.request.MonsterRaceRequestList;
import com.questgames.monster.tactics.response.MonsterRaceResponse;
import com.questgames.monster.tactics.response.MonsterRaceResponseList;
import com.questgames.monster.tactics.response.common.BaseReturn;
import com.questgames.monster.tactics.service.interfaces.MonsterRaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonsterRaceServiceImpl implements MonsterRaceService {
    @Autowired
    private MonsterElementTypeRepository monsterElementTypeRepository;
    @Autowired
    private MonsterRaceRepository repository;
    @Autowired
    private MonsterRaceMapper mapper;

    @Override
    public BaseReturn<MonsterRaceResponse> createNewMonsterRace(MonsterRaceRequest request) {
        MonsterElementType monsterElementType = monsterElementTypeRepository.findByUuid(request.monsterElementId);
        MonsterRace monsterRace = mapper.create(request, monsterElementType);
        monsterRace = repository.save(monsterRace);
        MonsterRaceResponse data = mapper.response(monsterRace);
        return new BaseReturn<>(data);
    }

    @Override
    public BaseReturn<List<MonsterRaceResponse>> listMonsterRace() {
        return null;
    }

    @Override
    public BaseReturn<MonsterRaceResponseList> batchRegistration(MonsterRaceRequestList request) {
        MonsterRaceResponseList data = new MonsterRaceResponseList();
        data.monsterRaceResponseList = request.monsterRaceRequestList.stream().map(m -> this.createNewMonsterRace(m)).collect(Collectors.toList());
        return new BaseReturn<>(data);
    }
}
