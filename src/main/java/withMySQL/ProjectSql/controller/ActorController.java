package withMySQL.ProjectSql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import withMySQL.ProjectSql.entity.Actor;
import withMySQL.ProjectSql.service.ActorService;

import java.util.List;

@RestController

public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping("/all_actor")
    public List<Actor> fetchActor(){
        return actorService.fetchActor();
    }

    //Find actor by his/her last name
    @GetMapping("/by_last_name/{lastName}")//URL would be like "/by_last_name/Smith"
    public List<Actor> fetchActorByLastName(@PathVariable String lastName){
        return actorService.fetchActorByLastName(lastName);
    }

    //Add new actor with his/her first name and last name
    @PostMapping("/addActor/{firstName}_{lastName}")//URL would be like "/addActor/John_Smith"
    public void addNewActor(@PathVariable String firstName,String lastName){
        actorService.addNewActor(firstName,lastName);
    }

    //Remove actor from record by his/her first and last name
    @PostMapping("/delActor/{firstName}_{lastName}")//URL would be like "/deleteActor/John_Smith"
    public void delActor(@PathVariable String firstName, String lastName){
        actorService.delActor(firstName,lastName);
    }

}
