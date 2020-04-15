package ua.lviv.lgs.money.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ua.lviv.lgs.money.domain.enumeration.Type;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@EqualsAndHashCode

public class TransactionDTO {

    private Long id;

    private BigDecimal amount;

    private String description;

    private Long categoryId;

    private Instant date;

    private Type type;


}
