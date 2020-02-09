package com.mspifarre.curriculum_ws.Entities;
import javax.persistence.Entity;

@Entity
public class Skill extends BaseEntity {

    private String name;
    private String description;
    // TODO : S'ha de definir el tipus de relació.
    // private Image logo;
    private double qualification;
}
