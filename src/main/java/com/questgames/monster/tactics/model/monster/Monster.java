package com.questgames.monster.tactics.model.monster;

import com.questgames.monster.tactics.model.common.BaseModel;
import com.questgames.monster.tactics.model.player.Team;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "monster")
@Entity
public class Monster extends BaseModel<Monster> {


    @Column(nullable = false, name = "uuid")
    public String uuid;

    @Column(nullable = false, name = "name")
    public String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monster_race", referencedColumnName = "id")
    public MonsterRace monsterRace;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team", referencedColumnName = "id")
    public Team team;

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
            uuid = "MON-" + UUID.randomUUID().toString();
        }
    }
}
