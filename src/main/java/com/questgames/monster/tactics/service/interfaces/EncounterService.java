package com.questgames.monster.tactics.service.interfaces;

import com.questgames.monster.tactics.response.EncounterResponse;
import com.questgames.monster.tactics.response.common.BaseReturn;

public interface EncounterService {
    BaseReturn<EncounterResponse> generateEncounter();
}
