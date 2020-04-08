package ua.lviv.lgs.money.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString

@Entity
public class Currency {

    @Id
    @GeneratedValue
    private Long id;

    private String code;

    private String name;

}
