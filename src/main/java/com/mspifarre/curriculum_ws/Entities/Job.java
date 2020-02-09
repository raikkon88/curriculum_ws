package com.mspifarre.curriculum_ws.Entities;

import javax.persistence.Entity;

@Entity
public class Job extends BaseEntity{

    private String companyName;
    private String companyUrl;
    private String period;
    private String description;
    private String task;

}
