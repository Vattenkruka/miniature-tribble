package se.experis.oscar.herokunate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.experis.oscar.herokunate.Models.Actor;

public interface ActorRepository  extends JpaRepository<Actor, Long> {
    Actor 
}
