package ua.lviv.lgs.money.domain;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Getter

@Entity
public class VerificationToken {

    @Value("${money-b.config.toke.time-to-live}")
    @Transient
    private int tokenTimeToLiveInHours;

    public VerificationToken() {
    }

    public VerificationToken(User user) {
        this.user = user;
        this.token = UUID.randomUUID().toString();
        this.expiredDate = Instant.now().plus(tokenTimeToLiveInHours, ChronoUnit.HOURS);
    }

    @Id
    @GeneratedValue
    private Long id;

    private String token;

    private Instant expiredDate;

    @OneToOne
    private User user;

}
