package labs.lab5.Entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class UniCategory {
    @Id
    private String id;
    private String name;
}
