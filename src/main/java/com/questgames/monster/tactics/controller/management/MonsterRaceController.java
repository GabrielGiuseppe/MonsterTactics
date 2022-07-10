package com.questgames.monster.tactics.controller.management;

import com.questgames.monster.tactics.controller.common.BaseController;
import com.questgames.monster.tactics.request.MonsterRaceRequest;
import com.questgames.monster.tactics.request.MonsterRaceRequestList;
import com.questgames.monster.tactics.response.MonsterRaceResponse;
import com.questgames.monster.tactics.response.MonsterRaceResponseList;
import com.questgames.monster.tactics.response.common.BaseReturn;
import com.questgames.monster.tactics.service.interfaces.MonsterRaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/monster_race")
public class MonsterRaceController extends BaseController {

    @Autowired
    private MonsterRaceService service;

    @PostMapping(produces = PRODUCES_JSON, consumes = CONSUMES_JSON)
    public BaseReturn<MonsterRaceResponse> create(@Valid @RequestBody MonsterRaceRequest request){
        return service.createNewMonsterRace(request);
    }

    @GetMapping(produces = PRODUCES_JSON, consumes = CONSUMES_ALL)
    public BaseReturn<List<MonsterRaceResponse>> list(){
        return service.listMonsterRace();
    }

    @PostMapping(path = "/batch", produces = PRODUCES_JSON, consumes = CONSUMES_JSON)
    public BaseReturn<MonsterRaceResponseList> batchRegistration(@Valid @RequestBody MonsterRaceRequestList request){
        return service.batchRegistration(request);
    }
}
