package com.mspifarre.curriculum_ws.Entities;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Post extends BaseEntity {

    private String title;
    // This text must be created with a qwerty keyboard or editor.
    private String text;
    private Date creationDate;

}
