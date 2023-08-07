package withMySQL.ProjectSql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import withMySQL.ProjectSql.entity.Actor;
import withMySQL.ProjectSql.repository.ActorRepository;

import java.util.List;

@Service
public class ActorServiceImplement implements ActorService {
    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> fetchActor(){
        return (List<Actor>) actorRepository.findAllActor();
    }

    @Override
    public List<Actor> fetchActorByLastName(String LastName) {
        return (List<Actor>) actorRepository.findByLastName(LastName);
    }

    @Transactional
    public void addNewActor(String firstName,String lastName){
        actorRepository.AddNewActor(firstName,lastName);
    }

    @Transactional
    public void delActor(String firstName, String lastName) {
        actorRepository.DelActor(firstName,lastName);
    }
}
