package com.questgames.monster.tactics.service.interfaces;

import com.questgames.monster.tactics.request.MonsterElementTypeRequest;
import com.questgames.monster.tactics.request.MonsterElementTypeRequestList;
import com.questgames.monster.tactics.response.MonsterElementTypeResponse;
import com.questgames.monster.tactics.response.MonsterElementTypeResponseList;
import com.questgames.monster.tactics.response.common.BaseReturn;

import java.util.List;

public interface MonsterElementTypeService {
    BaseReturn<MonsterElementTypeResponse> createNewElementType(MonsterElementTypeRequest request);

    BaseReturn<List<MonsterElementTypeResponse>> listMonsterElementType();

    BaseReturn<MonsterElementTypeResponseList> batchRegistration(MonsterElementTypeRequestList request);
}
