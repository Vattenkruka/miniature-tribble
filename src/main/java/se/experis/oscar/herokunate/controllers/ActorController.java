package se.experis.oscar.herokunate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.experis.oscar.herokunate.Models.CommonResponse;
import se.experis.oscar.herokunate.repositories.ActorRepository;
import se.experis.oscar.herokunate.utils.Command;
import se.experis.oscar.herokunate.utils.Logger;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ActorController {
    @Autowired
    private ActorRepository actorRepository;

    @GetMapping("/actor")
    public ResponseEntity<CommonResponse> actorRoot(HttpServletRequest request){
        Command cmd = new Command(request);

        CommonResponse commonResponse = new CommonResponse();
        commonResponse.data = null;
        commonResponse. message = "Not implemented";

        HttpStatus resp = HttpStatus.NOT_IMPLEMENTED;

        cmd.setResult(resp);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(commonResponse,resp);
    }

    @GetMapping("/actor/all")
    public ResponseEntity<CommonResponse> getAllActors(HttpServletRequest request){
        Command cmd = new Command(request);

        CommonResponse commonResponse = new CommonResponse();
        commonResponse.data = actorRepository.findAll();
        commonResponse.message = "All Actors";

        HttpStatus resp = HttpStatus.OK;

        cmd.setResult(resp);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(commonResponse, resp);
    }

    @GetMapping("/actor/{id}")
    public ResponseEntity<CommonResponse> getActorById(HttpServletRequest request, @PathVariable("id") Long id){
        Command cmd = new Command(request);

        CommonResponse commonResponse = new CommonResponse();
        HttpStatus resp;

        if(actorRepository.existsById(id)){
            commonResponse.data = actorRepository.findById(id);
            commonResponse.message = "Actor with id: " + id;
            resp = HttpStatus.OK;
        } else{
            commonResponse.data = null;
            commonResponse.message = "Actor not found";
            resp = HttpStatus.NOT_FOUND;
        }

        cmd.setResult(resp);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(commonResponse,resp);
    }
}
