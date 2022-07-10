package com.questgames.monster.tactics.service.interfaces;

import com.questgames.monster.tactics.request.MonsterRaceRequest;
import com.questgames.monster.tactics.request.MonsterRaceRequestList;
import com.questgames.monster.tactics.response.MonsterRaceResponse;
import com.questgames.monster.tactics.response.MonsterRaceResponseList;
import com.questgames.monster.tactics.response.common.BaseReturn;

import java.util.List;

public interface MonsterRaceService {
    BaseReturn<MonsterRaceResponse> createNewMonsterRace(MonsterRaceRequest request);

    BaseReturn<List<MonsterRaceResponse>> listMonsterRace();

    BaseReturn<MonsterRaceResponseList> batchRegistration(MonsterRaceRequestList request);
}
