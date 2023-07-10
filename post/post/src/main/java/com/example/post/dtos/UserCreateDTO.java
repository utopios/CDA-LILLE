package com.example.post.dtos;



import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class UserCreateDTO
{
    private Long id;

    @Size(min=2,max=15,message = "La taille doit être au minimum de {min} et maximum de {max}")
    private String userName;

    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]{2})(?=.*?[#?!@$%^&*-]).{0,8}$", message = "Le format du mot de passe n'est pas valide")
    private String password;


}
