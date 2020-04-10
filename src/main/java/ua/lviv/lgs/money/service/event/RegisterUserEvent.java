package ua.lviv.lgs.money.service.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import ua.lviv.lgs.money.domain.User;

@Getter

public class RegisterUserEvent extends ApplicationEvent {

    private User user;

    private String appUrl;

    public RegisterUserEvent(Object source, User user, String appUrl) {
        super(source);
        this.user = user;
        this.appUrl = appUrl;
    }
}
