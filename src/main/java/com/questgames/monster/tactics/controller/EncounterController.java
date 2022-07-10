package com.questgames.monster.tactics.controller;

import com.questgames.monster.tactics.controller.common.BaseController;
import com.questgames.monster.tactics.response.EncounterResponse;
import com.questgames.monster.tactics.response.common.BaseReturn;
import com.questgames.monster.tactics.service.interfaces.EncounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encounter")
public class EncounterController extends BaseController {

    @Autowired
    private EncounterService service;

    @GetMapping(produces = PRODUCES_JSON, consumes = CONSUMES_JSON)
    public BaseReturn<EncounterResponse> generateEncounter(){
        return service.generateEncounter();
    }

}
