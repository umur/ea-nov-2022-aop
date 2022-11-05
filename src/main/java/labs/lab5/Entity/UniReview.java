package labs.lab5.Entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class UniReview {
    @Id
    private String id;
    private String comment;
}
