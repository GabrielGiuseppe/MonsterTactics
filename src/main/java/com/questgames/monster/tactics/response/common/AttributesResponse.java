package com.questgames.monster.tactics.response.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttributesResponse {

    public Integer str;
    public Integer agi;
    public Integer con;
    @JsonProperty("int")
    public Integer inte;
    public Integer dex;
    public Integer luk;


}
