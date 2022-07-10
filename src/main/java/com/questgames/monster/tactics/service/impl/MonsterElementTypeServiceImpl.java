package com.questgames.monster.tactics.service.impl;

import com.questgames.monster.tactics.mapper.MonsterElementTypeMapper;
import com.questgames.monster.tactics.model.monster.MonsterElementType;
import com.questgames.monster.tactics.repository.MonsterElementTypeRepository;
import com.questgames.monster.tactics.request.MonsterElementTypeRequest;
import com.questgames.monster.tactics.request.MonsterElementTypeRequestList;
import com.questgames.monster.tactics.response.MonsterElementTypeResponse;
import com.questgames.monster.tactics.response.MonsterElementTypeResponseList;
import com.questgames.monster.tactics.response.common.BaseReturn;
import com.questgames.monster.tactics.service.interfaces.MonsterElementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonsterElementTypeServiceImpl implements MonsterElementTypeService {
    @Autowired
    private MonsterElementTypeRepository repository;
    @Autowired
    private MonsterElementTypeMapper monsterElementTypeMapper;

    @Override
    public BaseReturn<MonsterElementTypeResponse> createNewElementType(MonsterElementTypeRequest request) {
        MonsterElementType elementType = monsterElementTypeMapper.create(request);
        elementType = repository.save(elementType);
        MonsterElementTypeResponse data = monsterElementTypeMapper.response(elementType);
        BaseReturn<MonsterElementTypeResponse> response = new BaseReturn<>(data);
        return response;
    }

    @Override
    public BaseReturn<List<MonsterElementTypeResponse>> listMonsterElementType() {
        List<MonsterElementType> monsterElementTypes = repository.findAll();
        List<MonsterElementTypeResponse> data =  monsterElementTypeMapper.response(monsterElementTypes);
        BaseReturn<List<MonsterElementTypeResponse>> response = new BaseReturn<>(data);
        return response;
    }

    @Override
    public BaseReturn<MonsterElementTypeResponseList> batchRegistration(MonsterElementTypeRequestList request) {
        MonsterElementTypeResponseList data = new MonsterElementTypeResponseList();
       data.monsterElementTypeResponseList = request.monsterElementTypeRequestList.stream().map(m -> this.createNewElementType(m)).collect(Collectors.toList());
       return new BaseReturn<>(data);
    }


}
