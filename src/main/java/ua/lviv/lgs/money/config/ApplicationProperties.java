package ua.lviv.lgs.money.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter

@Component
public class ApplicationProperties {

    @Value("${money-b.config.token.time-to-live}")
    private int tokenTimeToLiveInHours;
}
