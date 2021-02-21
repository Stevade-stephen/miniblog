package com.miniblog.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {
    boolean isSuccessful;
    int status;
    String error;
    Object data;
}
