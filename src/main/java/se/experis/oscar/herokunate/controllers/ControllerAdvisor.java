package se.experis.oscar.herokunate.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import se.experis.oscar.herokunate.Models.CommonResponse;
import se.experis.oscar.herokunate.utils.Command;
import se.experis.oscar.herokunate.utils.Logger;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<CommonResponse> handle(HttpServletRequest request, Exception ex){
        Command cmd = new Command(request);

        CommonResponse cr = new CommonResponse();
        cr.message = request.getRequestURI() + " was not found";

        //Logs if it can't find the url
        cmd.setResult(HttpStatus.NOT_FOUND);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(cr, HttpStatus.NOT_FOUND);
    }
}
