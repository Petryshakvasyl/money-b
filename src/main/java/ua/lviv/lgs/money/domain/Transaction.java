package ua.lviv.lgs.money.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.lviv.lgs.money.domain.enumeration.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@ToString

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal amount;
    private Instant date;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private Type type;

    @OneToOne
    private Category category;

}
