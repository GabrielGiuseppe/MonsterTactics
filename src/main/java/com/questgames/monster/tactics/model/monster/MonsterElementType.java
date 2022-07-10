package com.questgames.monster.tactics.model.monster;

import com.questgames.monster.tactics.model.common.BaseModel;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = "monster_element_type")
@Entity
public class MonsterElementType extends BaseModel<MonsterElementType> {

    @Column(nullable = false, name = "uuid")
    public String uuid;

    @Column(nullable = false, name = "name")
    public String name;

    @Column(nullable = false, name = "tag")
    public String tag;

    @PrePersist
    public void initializeUUID() {
        if (Strings.isBlank(uuid)) {
            uuid = "MET-" + UUID.randomUUID().toString();
        }
    }
}
