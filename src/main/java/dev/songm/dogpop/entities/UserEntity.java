package dev.songm.dogpop.entities;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;

    @Column(length = 80, nullable = false)
    private String email;
    @Column(length = 128)
    private String password;
    @Column(length = 40)
    private String name;
    @Column(length = 11)
    private String contact;
    @Column(length = 1)
    private String gender;
    @Column(length = 8)
    private String birthday;
    @Column(length = 5)
    private String addressPostal;
    @Column(length = 100)
    private String addressPrimary;
    @Column(length = 100)
    private String addressSecondary;
    private boolean isAdmin;

}
