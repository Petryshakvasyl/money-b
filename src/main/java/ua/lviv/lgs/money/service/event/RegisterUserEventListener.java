package ua.lviv.lgs.money.service.event;

import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import ua.lviv.lgs.money.domain.User;
import ua.lviv.lgs.money.domain.VerificationToken;
import ua.lviv.lgs.money.repository.VerificationTokenRepository;

@Component
@AllArgsConstructor
public class RegisterUserEventListener {

    private final JavaMailSender mailSender;

    private final VerificationTokenRepository tokenRepository;

    @EventListener
    public void handleRegistrationUer(RegisterUserEvent event) {
        User user = event.getUser();
        String baseUrl = event.getAppUrl();

        VerificationToken token = tokenRepository.save(new VerificationToken(user));

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(user.getEmail());
        message.setSubject("Registration confirm");
        message.setText(
                "For comfirm registration please clik the link below " + baseUrl + "/confirmRegistration?token=" +
                        token.getToken());
        mailSender.send(message);

    }

}
