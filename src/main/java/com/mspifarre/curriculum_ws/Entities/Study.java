package com.mspifarre.curriculum_ws.Entities;
import javax.persistence.Entity;

@Entity
public class Study extends BaseEntity{

    private String name;
    private String category;
    private String place;
    private String period; // from day to day
    private String description;

}
