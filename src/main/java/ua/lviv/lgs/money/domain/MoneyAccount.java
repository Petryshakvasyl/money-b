package ua.lviv.lgs.money.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = "transactions")

@Entity
public class MoneyAccount {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal initialBalance;

    private Instant initialDate;

    @OneToOne
    private Currency currency;

    @OneToMany
    private Set<Transaction> transactions = new HashSet<>();

}
