package com.questgames.monster.tactics.model.monster;

import com.questgames.monster.tactics.model.common.BaseModel;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = "attributes")
@Entity
public class Attributes extends BaseModel<Attributes> {

    private static final long serialVersionUID = -1590585369178420096L;
    @Column(nullable = false, name = "uuid")
    public String uuid;

    @Column(nullable = false, name = "str")
    public Integer str;

    @Column(nullable = false, name = "agi")
    public Integer agi;

    @Column(nullable = false, name = "con")
    public Integer con;

    @Column(nullable = false, name = "int")
    public Integer inte;

    @Column(nullable = false, name = "dex")
    public Integer dex;

    @Column(nullable = false, name = "luk")
    public Integer luk;


    @PrePersist
    public void initializeUUID() {
        if (Strings.isBlank(uuid)) {
            uuid = "ATT-" + UUID.randomUUID().toString();
        }
    }
}
