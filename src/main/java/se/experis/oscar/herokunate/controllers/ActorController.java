package se.experis.oscar.herokunate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.experis.oscar.herokunate.repositories.ActorRepository;

@RestController
public class ActorController {
    @Autowired
    private ActorRepository actorRepository;
}
