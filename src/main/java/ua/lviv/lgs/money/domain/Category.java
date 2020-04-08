package ua.lviv.lgs.money.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.lviv.lgs.money.domain.enumeration.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString

@Entity

public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Type type;

}
