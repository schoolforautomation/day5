package tech.schoolforautomation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignUp {

    private int courseIndex;

    private int levelIndex;

    private String name;

    private String email;

    private String message;
}
