package com.questgames.monster.tactics.controller.common;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

	protected static final String PRODUCES_JSON = MediaType.APPLICATION_JSON_VALUE;
	protected static final String CONSUMES_JSON = MediaType.APPLICATION_JSON_VALUE;
	protected static final String CONSUMES_ALL = MediaType.ALL_VALUE;

}
