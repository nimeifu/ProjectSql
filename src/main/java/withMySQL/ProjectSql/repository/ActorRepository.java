package withMySQL.ProjectSql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import withMySQL.ProjectSql.entity.Actor;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    @Query(value = "SELECT * FROM actor WHERE last_name = ?1 ORDER BY last_name", nativeQuery = true)
    List<Actor> findByLastName(String lastName);

    @Query(value = "SELECT*FROM actor",nativeQuery = true)
    List<Actor> findAllActor();

    /*
    Add record unless it does not exist in the database
     */
    @Modifying
    @Query(value = "INSERT INTO actor (first_name, last_name) SELECT ?1,?2 " +
            "WHERE NOT EXISTS " +
            "(SELECT first_name,last_name FROM actor WHERE first_name = ?1 AND last_name = ?2)", nativeQuery = true)
    void AddNewActor(String firstName, String lastName);

    @Modifying
    @Query(value = "DELETE FROM actor WHERE first_name = ?1 AND last_name = ?2",nativeQuery = true)
    void DelActor(String firstName, String lastName);
}
