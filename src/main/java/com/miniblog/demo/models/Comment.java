package com.miniblog.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class Comment extends BaseModel{
    @NotBlank
    private String body;
    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;
}
