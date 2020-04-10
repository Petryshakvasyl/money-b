package ua.lviv.lgs.money.service.event;

import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import ua.lviv.lgs.money.domain.User;

@Component
@AllArgsConstructor
public class RegisterUserEventListener {

    private final JavaMailSender mailSender;

    @EventListener
    public void handleRegistrationUer(RegisterUserEvent event) {
        User user = event.getUser();
        String baseUrl = event.getAppUrl();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(user.getEmail());
        message.setSubject("Registration confirm");
        message.setText("For comfirm registration please clik the link below " );
    }

}
