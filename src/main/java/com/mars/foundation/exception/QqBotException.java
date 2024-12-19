package com.mars.foundation.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QqBotException extends RuntimeException {

    @JsonProperty("message")
    String message;

    @JsonProperty("code")
    long code;

    @JsonProperty("err_code")
    long err_code;

    @JsonProperty("trace_id")
    String trace_id;


    @JsonCreator
    public QqBotException(@JsonProperty("message") String message,
                          @JsonProperty("code") long code,
                          @JsonProperty("err_code") long err_code,
                          @JsonProperty("trace_id") String trace_id) {
        this.message = message;
        this.code = code;
        this.err_code = err_code;
        this.trace_id = trace_id;
    }

}
