package withMySQL.ProjectSql.service;

import withMySQL.ProjectSql.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> fetchActor();

    List<Actor> fetchActorByLastName(String LastName);

    void addNewActor(String firstName, String lastName);

    void delActor(String firstName, String lastName);
}
