package com.questgames.monster.tactics.model.player;

import com.questgames.monster.tactics.model.common.BaseModel;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "player")
@Entity
public class Player extends BaseModel<Player> {

    @Column(nullable = false, name = "uuid")
    public String uuid;

    @Column(nullable = false, name = "name")
    public String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team", referencedColumnName = "id")
    public Team team;

    @PrePersist
    public void initializeUUID() {
        if (Strings.isBlank(uuid)) {
            uuid = "PLA-" + UUID.randomUUID().toString();
        }
    }

}
