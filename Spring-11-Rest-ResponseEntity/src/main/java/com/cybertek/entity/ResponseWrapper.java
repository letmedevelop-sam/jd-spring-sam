package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.persistence.GeneratedValue;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {
    private boolean success;
    private String message;
    private Integer code;
    private  Object data;

    public ResponseWrapper(String message, Object data) {
        this.success = true;
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.data = data;
    }

    public ResponseWrapper(String message) {
        this.success = true;
        this.message = message;
        this.code = HttpStatus.OK.value();
    }
}
