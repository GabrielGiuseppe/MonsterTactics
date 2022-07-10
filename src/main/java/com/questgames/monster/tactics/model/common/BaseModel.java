package com.questgames.monster.tactics.model.common;


import com.questgames.monster.tactics.utils.TimeZones;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseModel<T extends BaseModel<T>> implements Serializable {

    private static final long serialVersionUID = 6325905633364486954L;

    public static final String ID = "id";
    public static final String DATE_MODEL = "dateModel";

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private DateModel dateModel;

    @Version
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateModel getDateModel() {
        return dateModel;
    }

    public void setDateModel(DateModel dateModel) {
        this.dateModel = dateModel;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @PrePersist
    public void initializeDates() {
        LocalDateTime now = LocalDateTime.now(TimeZones.getUtc());
        dateModel = new DateModel(now, now);
    }

    @PreUpdate
    public void updateUpdatedAt() {
        dateModel.setUpdatedAt(LocalDateTime.now(TimeZones.getUtc()));
    }
}