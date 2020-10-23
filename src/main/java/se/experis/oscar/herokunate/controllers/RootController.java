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

        CommonResponse cr = new CommonResponse();
        cr.message = "Hello world";

        cmd.setResult(HttpStatus.OK);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(cr, HttpStatus.OK);
    }

    @GetMapping("/log")
    public ResponseEntity<ArrayList<Command>> log(HttpServletRequest request){
        Command cmd = new Command(request);

        cmd.setResult(HttpStatus.OK);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<ArrayList<Command>>(Logger.getInstance().getLog(),HttpStatus.OK);
    }
}
