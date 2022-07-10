package com.questgames.monster.tactics.controller;


import com.questgames.monster.tactics.controller.common.BaseController;
import com.questgames.monster.tactics.request.PlayerRequest;
import com.questgames.monster.tactics.response.PlayerResponse;
import com.questgames.monster.tactics.response.common.BaseReturn;
import com.questgames.monster.tactics.service.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/player")
public class PlayerController extends BaseController {

    @Autowired
    private PlayerService service;

    @PostMapping(produces = PRODUCES_JSON, consumes = CONSUMES_JSON)
    public BaseReturn<PlayerResponse> generateEncounter(@Valid @RequestBody PlayerRequest request){
        return service.createNewPlayer(request);
    }

}
