package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;



@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AdminGeneral implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    @OneToMany(mappedBy = "adminGeneral",fetch = FetchType.LAZY)
    private List<AdminCenter> adminCenter;

    //getters and setters

}
