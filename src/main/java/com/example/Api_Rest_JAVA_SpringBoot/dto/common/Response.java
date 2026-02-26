package com.example.Api_Rest_JAVA_SpringBoot.dto.common;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.message.Message;

@Getter
public class Response<T> {

    private boolean success;
    private String Message;
    private T data;

    public Response(boolean success, String Message, T data){
        this.success = success;
        this.Message = Message;
        this.data = data;

    }
}

