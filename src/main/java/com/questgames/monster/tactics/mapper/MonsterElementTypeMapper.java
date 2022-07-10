package com.questgames.monster.tactics.mapper;

import com.questgames.monster.tactics.model.monster.MonsterElementType;
import com.questgames.monster.tactics.request.MonsterElementTypeRequest;
import com.questgames.monster.tactics.response.MonsterElementTypeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonsterElementTypeMapper {

    public List<MonsterElementTypeResponse> response(List<MonsterElementType> monsterElementTypes) {
        List<MonsterElementTypeResponse> responses = monsterElementTypes.stream().map(m -> this.response(m)).collect(Collectors.toList());
        return responses;
    }

    public MonsterElementTypeResponse response(MonsterElementType monsterElementType) {
        MonsterElementTypeResponse response = new MonsterElementTypeResponse();
        response.elementId = monsterElementType.uuid;
        response.elementName = monsterElementType.name;
        response.elementTag = monsterElementType.tag;
        return response;
    }

    public MonsterElementType create(MonsterElementTypeRequest request) {
        MonsterElementType response = new MonsterElementType();
        response.name = request.name;
        response.tag = request.tag;
        return response;
    }
}
