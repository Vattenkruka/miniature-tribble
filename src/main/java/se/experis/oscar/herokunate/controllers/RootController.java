package se.experis.oscar.herokunate.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.experis.oscar.herokunate.Models.CommonResponse;
import se.experis.oscar.herokunate.utils.Command;
import se.experis.oscar.herokunate.utils.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
public class RootController {

    @GetMapping("/")
    public ResponseEntity<CommonResponse> landing(HttpServletRequest request){
        Command cmd = new Command(request);

        //process of the main route, in this specific case only a hello world test

        CommonResponse commonResponse = new CommonResponse();
        commonResponse.message = "Hello world";

        //logs it

        cmd.setResult(HttpStatus.OK);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    @GetMapping("/log")
    public ResponseEntity<ArrayList<Command>> log(HttpServletRequest request){
        Command cmd = new Command(request);

        //Logs and returns it to the /log endpoint

        cmd.setResult(HttpStatus.OK);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<ArrayList<Command>>(Logger.getInstance().getLog(),HttpStatus.OK);
    }
}
