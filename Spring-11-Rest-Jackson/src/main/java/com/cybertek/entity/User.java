package com.cybertek.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_account")     // WE CANNOT USE user as a table name
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}, ignoreUnknown = true)
public class User extends BaseEntity{

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)  //We will be able to add password but we will not see it in JSON
    private String password;

    private String username;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "account_details_id")
    @JsonManagedReference
    private Account account;

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
