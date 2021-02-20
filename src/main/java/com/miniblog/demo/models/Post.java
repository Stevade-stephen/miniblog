package com.miniblog.demo.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Post extends BaseModel {
    @ManyToOne
    private User user;
    @NotBlank
    private String title;
    @NotBlank
    private String body;
}
