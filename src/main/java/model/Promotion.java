package model;

import helpers.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Promotion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private StatusEnum status = StatusEnum.PENDING;

    private Date date;

    @ManyToOne
    private AdminCenter adminCenter;

    @OneToOne
    private SubCategory subCategory;

    //getters and setters
}
