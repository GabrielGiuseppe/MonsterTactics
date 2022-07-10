package com.questgames.monster.tactics.model.monster;

import com.questgames.monster.tactics.model.common.BaseModel;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "monster_race")
@Entity
public class MonsterRace extends BaseModel<MonsterRace> {

    @Column(nullable = false, name = "uuid")
    public String uuid;

    @Column(nullable = false, name = "name")
    public String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monster_element_type", referencedColumnName = "id")
    public MonsterElementType monsterElementType;

    @PrePersist
    public void initializeUUID() {
        if (Strings.isBlank(uuid)) {
            uuid = "MRC-" + UUID.randomUUID().toString();
        }
    }
}
