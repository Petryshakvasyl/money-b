package ua.lviv.lgs.money.service.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter

public class UserDTO {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String username;

    @NotNull
    @Min(8)
    private String password;

    @NotNull
    private String passwordConfirm;

    @NotNull
    @Email
    private String email;

    private List<MultipartFile> avatar;
}
