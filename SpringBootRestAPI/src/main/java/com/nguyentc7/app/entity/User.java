package com.nguyentc7.app.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone",length = 11)
    private String phone;

    @Column(name = "avatar", nullable = true)
    private String avatar;

    @Column(name = "password")
    private String password;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "role", columnDefinition = "varchar(255) default 'USER'")
    private String role;

    @OneToOne
    @JoinColumn(name = "identity_card_id")
    private IdentityCard identityCard;

    @OneToMany(mappedBy = "user")
    private List<Order> order;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}
