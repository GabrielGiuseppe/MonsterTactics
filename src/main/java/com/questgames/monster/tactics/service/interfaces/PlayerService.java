package com.questgames.monster.tactics.service.interfaces;

import com.questgames.monster.tactics.request.PlayerRequest;
import com.questgames.monster.tactics.response.PlayerResponse;
import com.questgames.monster.tactics.response.common.BaseReturn;

public interface PlayerService {
    BaseReturn<PlayerResponse> createNewPlayer(PlayerRequest request);
}
