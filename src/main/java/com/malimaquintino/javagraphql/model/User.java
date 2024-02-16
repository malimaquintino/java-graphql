package com.malimaquintino.javagraphql.model;

import com.malimaquintino.javagraphql.dto.UserInputDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", allocationSize = 1)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;

    public static User parseFromDto(UserInputDto userInputDto) {
        return User.builder()
                .id(userInputDto.getId())
                .name(userInputDto.getName())
                .email(userInputDto.getEmail())
                .build();
    }

}
