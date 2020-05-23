package com.oop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 25, unique = true, nullable = false)
    private String username;
    @Column(length = 50, unique = true)
    private String email;
    @Column(length = 25)
    private String firstName;
    @Column(length = 35)
    private String lastName;
    @Column(length = 30)
    @JsonIgnore
    private String password;
//    @Column(length=30)
//    private String address;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "roles_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.username);
        hash = 13 * hash + Objects.hashCode(this.email);
        hash = 13 * hash + Objects.hashCode(this.firstName);
        hash = 13 * hash + Objects.hashCode(this.lastName);
        hash = 13 * hash + Objects.hashCode(this.password);
        hash = 13 * hash + Objects.hashCode(this.roles);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AppUser other = (AppUser) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AppUser{" + "id=" + id + ", username=" + username + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", roles=" + roles + '}';
    }

}
