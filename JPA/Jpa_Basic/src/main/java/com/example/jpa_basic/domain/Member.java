package com.example.jpa_basic.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_MEMBER")
public class Member {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @Column(name = "NICKNAME")
    private String nickname;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "BIRTHDAY")
    private Date birthday;
}
