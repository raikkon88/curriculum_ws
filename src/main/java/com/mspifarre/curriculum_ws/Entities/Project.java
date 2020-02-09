package com.mspifarre.curriculum_ws.Entities;

import javax.persistence.Entity;

@Entity
public class Project  extends BaseEntity {

    private String name;
    private String description;
    private String projectUrl;

}
