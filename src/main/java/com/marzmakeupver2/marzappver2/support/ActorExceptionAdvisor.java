package com.marzmakeupver2.marzappver2.support;

import com.marzmakeupver2.marzappver2.shared.api.response.ErrorMessageResponse;
import com.marzmakeupver2.marzappver2.support.exception.ActorNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ActorExceptionAdvisor {

    private static final Logger LOG = LoggerFactory.getLogger(ActorExceptionAdvisor.class);

    @ExceptionHandler(ActorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse actorNotFound(ActorNotFoundException exception) {
        LOG.error(exception.getMessage(), exception);
        return new ErrorMessageResponse(exception.getLocalizedMessage());
    }
}
