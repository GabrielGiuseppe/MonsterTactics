package com.questgames.monster.tactics.model.player;

import com.questgames.monster.tactics.model.common.BaseModel;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = "team")
@Entity
public class Team extends BaseModel<Team> {

    @Column(nullable = false, name = "uuid")
    public String uuid;

    @PrePersist
    public void initializeUUID() {
        if (Strings.isBlank(uuid)) {
            uuid = "TEA-" + UUID.randomUUID().toString();
        }
    }
}
