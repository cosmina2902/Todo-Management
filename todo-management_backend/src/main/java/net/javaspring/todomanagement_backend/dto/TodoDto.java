package net.javaspring.todomanagement_backend.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
public class TodoDto {

    private int Id;
    private String title;
    private String description;
    private boolean completed;
}
