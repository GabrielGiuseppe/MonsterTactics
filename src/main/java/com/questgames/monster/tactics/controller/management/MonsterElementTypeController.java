package com.questgames.monster.tactics.controller.management;


import com.questgames.monster.tactics.controller.common.BaseController;
import com.questgames.monster.tactics.request.MonsterElementTypeRequest;
import com.questgames.monster.tactics.request.MonsterElementTypeRequestList;
import com.questgames.monster.tactics.response.MonsterElementTypeResponse;
import com.questgames.monster.tactics.response.MonsterElementTypeResponseList;
import com.questgames.monster.tactics.response.common.BaseReturn;
import com.questgames.monster.tactics.service.interfaces.MonsterElementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/monster_element_type")
public class MonsterElementTypeController extends BaseController {


    @Autowired
    private MonsterElementTypeService service;

    @PostMapping(produces = PRODUCES_JSON, consumes = CONSUMES_JSON)
    public BaseReturn<MonsterElementTypeResponse> create(@Valid @RequestBody MonsterElementTypeRequest request){
        return service.createNewElementType(request);
    }

    @GetMapping(produces = PRODUCES_JSON, consumes = CONSUMES_ALL)
    public BaseReturn<List<MonsterElementTypeResponse>> list(){
        return service.listMonsterElementType();
    }

    @PostMapping(path = "/batch", produces = PRODUCES_JSON, consumes = CONSUMES_JSON)
    public BaseReturn<MonsterElementTypeResponseList> batchRegistration(@Valid @RequestBody MonsterElementTypeRequestList request){
        return service.batchRegistration(request);
    }
}
