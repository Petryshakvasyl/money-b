package ua.lviv.lgs.money.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String username;

    @OneToMany
    @JoinColumn
    Set<MoneyAccount> accounts = new HashSet<>();

    @OneToOne
    private MoneyAccount currentAccount;

}
