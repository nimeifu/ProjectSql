package withMySQL.ProjectSql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "actor")
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long actor_id;
    private String first_name;
    private String last_name;
    private String last_update;




}
