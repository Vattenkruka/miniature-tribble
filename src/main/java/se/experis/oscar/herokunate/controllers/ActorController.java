package se.experis.oscar.herokunate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.oscar.herokunate.Models.Actor;
import se.experis.oscar.herokunate.Models.CommonResponse;
import se.experis.oscar.herokunate.repositories.ActorRepository;
import se.experis.oscar.herokunate.utils.Command;
import se.experis.oscar.herokunate.utils.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
public class ActorController {
    @Autowired
    private ActorRepository actorRepository;

    //The route for actor, nothing implemented here as of yet.

    @GetMapping("/actor")
    public ResponseEntity<CommonResponse> actorRoot(HttpServletRequest request) {
        Command cmd = new Command(request);

        //The process

        CommonResponse commonResponse = new CommonResponse();
        commonResponse.data = null;
        commonResponse.message = "Not implemented";

        HttpStatus resp = HttpStatus.NOT_IMPLEMENTED;

        //Logging the command and the response

        cmd.setResult(resp);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(commonResponse, resp);
    }

    //The endpoint for getting all actors in the database

    @GetMapping("/actor/all")
    public ResponseEntity<CommonResponse> getAllActors(HttpServletRequest request) {
        Command cmd = new Command(request);

        //The process of finding all actors in the table (The read all function)

        CommonResponse commonResponse = new CommonResponse();
        commonResponse.data = actorRepository.findAll();
        commonResponse.message = "All Actors";

        HttpStatus resp = HttpStatus.OK;

        //Logging the command and the response

        cmd.setResult(resp);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(commonResponse, resp);
    }

    //The endpoint for getting all actors by a certain id

    @GetMapping("/actor/{id}")
    public ResponseEntity<CommonResponse> getActorById(HttpServletRequest request, @PathVariable("id") Long id) {
        Command cmd = new Command(request);

        //The process of finding a specific actor by using the .findById() from the JPA

        CommonResponse commonResponse = new CommonResponse();
        HttpStatus resp;

        if (actorRepository.existsById(id)) {
            commonResponse.data = actorRepository.findById(id);
            commonResponse.message = "Actor with id: " + id;
            resp = HttpStatus.OK;
        } else {
            commonResponse.data = null;
            commonResponse.message = "Actor not found";
            resp = HttpStatus.NOT_FOUND;
        }

        //Logging the command and the response

        cmd.setResult(resp);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(commonResponse, resp);
    }

    //The endpoint for adding a new actor to the table in the database

    @PostMapping("/actor")
    public ResponseEntity<CommonResponse> addActor(HttpServletRequest request, HttpServletResponse response, @RequestBody Actor actor) {
        Command cmd = new Command(request);

        //The process of adding a new Actor to the table by using the .save() method from the JPA

        actor = actorRepository.save(actor);

        CommonResponse commonResponse = new CommonResponse();
        commonResponse.data = actor;
        commonResponse.message = "New actor with id: " + actor.getId();

        HttpStatus resp = HttpStatus.CREATED;

        //Logging the command and the response

        cmd.setResult(resp);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(commonResponse, resp);
    }

    //The endpoint for updating a certain actor by the actor's id

    @PatchMapping("/actor/{id}")
    public ResponseEntity<CommonResponse> updateActor(HttpServletRequest request, @RequestBody Actor newActor, @PathVariable Long id) {
        Command cmd = new Command(request);

        CommonResponse commonResponse = new CommonResponse();
        HttpStatus resp;

        //The process of updating a specific actor

        if (actorRepository.existsById(id)) {
            Optional<Actor> actorRepo = actorRepository.findById(id);
            Actor actor = actorRepo.get();

            if (newActor.getFirstName() != null) {
                actor.setFirstName(newActor.getFirstName());
            }
            if (newActor.getLastName() != null) {
                actor.setLastName(newActor.getLastName());
            }
            if (newActor.getDateOfBirth() != null) {
                actor.setDateOfBirth(newActor.getDateOfBirth());
            }
            if (newActor.getUrl() != null) {
                actor.setUrl(newActor.getUrl());
            }
            actorRepository.save(actor);

            commonResponse.data = actor;
            commonResponse.message = "Updated actor with id: " + actor.getId();
            resp = HttpStatus.OK;
        } else {
            commonResponse.message = "Actor not found with this id: " + id;
            resp = HttpStatus.NOT_FOUND;
        }

        //Logging the command and the response

        cmd.setResult(resp);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(commonResponse, resp);

    }

    //A endpoint for using the put-method to update/replace an actor's attributes by it's id

    @PutMapping("/actor/{id}")
    public ResponseEntity<CommonResponse> replaceActor(HttpServletRequest request, @RequestBody Actor newActor, @PathVariable Long id) {
        Command cmd = new Command(request);

        CommonResponse commonResponse = new CommonResponse();
        HttpStatus resp;

        // The process of updating or replacing an actor.

        if (actorRepository.existsById(id)) {
            Optional<Actor> actorRepo = actorRepository.findById(id);
            Actor actor = actorRepo.get();

            actor.setFirstName(newActor.getFirstName());
            actor.setLastName(newActor.getLastName());
            actor.setDateOfBirth(newActor.getDateOfBirth());
            actor.setUrl(newActor.getUrl());

            actorRepository.save(actor);

            commonResponse.data = actor;
            commonResponse.message = "Replaced actor with id: " + actor.getId();
            resp = HttpStatus.OK;
        } else {
            commonResponse.message = "Actor not found with id: " + id;
            resp = HttpStatus.NOT_FOUND;
        }

        //Logging the command and the response

        cmd.setResult(resp);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(commonResponse, resp);
    }

    //

    @DeleteMapping("/actor/{id}")
    public ResponseEntity<CommonResponse> deleteActor(HttpServletRequest request, @PathVariable Long id) {
        Command cmd = new Command(request);

        CommonResponse commonResponse = new CommonResponse();
        HttpStatus resp;

        //The process of deleting an actor from the table in the database by a certain id

        if (actorRepository.existsById(id)) {
            actorRepository.deleteById(id);
            commonResponse.message = "Deleted actor with id: " + id;
            resp = HttpStatus.OK;
        } else {
            commonResponse.message = "Actor not found with id: " + id;
            resp = HttpStatus.NOT_FOUND;
        }

        //Logging the command and the response

        cmd.setResult(resp);
        Logger.getInstance().logCommand(cmd);
        return new ResponseEntity<>(commonResponse, resp);
    }

}
