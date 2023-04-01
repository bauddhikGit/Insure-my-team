package assignment.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Component
@Entity
@EntityScan
//@Scope(value = "prototype")
@Table(name = "Client")
@ToString
public class Client {

    @Id
    private int id;
    private String name;
//    private String language;
    private String tech;



}

