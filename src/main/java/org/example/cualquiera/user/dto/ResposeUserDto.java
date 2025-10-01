package org.example.cualquiera.user.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResposeUserDto {
    @NotNull
    private Long id;
}
