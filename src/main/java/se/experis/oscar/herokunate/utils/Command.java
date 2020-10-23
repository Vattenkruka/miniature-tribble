package se.experis.oscar.herokunate.utils;

import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;


public class Command {

    public HttpStatus result;

    public String requestMethod = "UNKNOWN";
    public String requestIP = "UNKNOWN";
    public String requestPath = "UNKNOWN";

    public Command(HttpServletRequest request) {
        this.requestIP = request.getRemoteAddr();
        this.requestPath = request.getRequestURI();
        this.requestMethod = request.getMethod();
    }

    public void setResult(HttpStatus result) {
        this.result = result;
    }

}
