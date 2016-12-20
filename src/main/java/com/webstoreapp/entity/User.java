package com.webstoreapp.entity;

import com.fasterxml.jackson.annotation.*;
import com.webstoreapp.error.InvalidEntityException;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {

    @Getter(lazy = false)
    @JsonProperty("_links")
    private List<Link> links = new ArrayList<>();

    public User addLink(String rel, String href) {
        this.links.add(new Link(rel, href));
        return this;
    }

    @JsonIgnore
    private Integer id;

    @NonNull
    private String username;

    @NonNull
    @Getter(AccessLevel.NONE)
    private String password;

    @Getter(AccessLevel.NONE)
    private String passwordHash;

    @NonNull
    private String emailAddress;

    private UserData userData;

    private Boolean isAdmin;

    public User(Integer id, String username, String passwordHash, String emailAddress, Boolean isAdmin, UserData userData) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.emailAddress = emailAddress;
        this.isAdmin = isAdmin;
        this.userData = userData;
    }

    public void validate() throws InvalidEntityException {
        validateUsername();
        validatePassword();
        validateEmailAddress();
    }

    public void generatePasswordHash() {
        passwordHash = BCrypt.hashpw(password, BCrypt.gensalt(11));
    }

    public boolean isUserPassword(String password) {
        return BCrypt.checkpw(password, passwordHash);
    }

    private void validateUsername() throws InvalidEntityException {
        int minimumLength = 4;
        int maximumLength = 32;

        if (StringUtils.isEmpty(username)) {
            throw new InvalidEntityException("Username cannot be empty.");
        }
        if (username.length() < minimumLength) {
            throw new InvalidEntityException("Username too short. Minimum length is " + minimumLength);
        }
        if (username.length() > maximumLength) {
            throw new InvalidEntityException("Username too long. Maximum length is " + maximumLength);
        }
    }

    private void validatePassword() throws InvalidEntityException {
        int minimumLength = 7;
        int maximumLength = 32;

        if (StringUtils.isEmpty(password)) {
            throw new InvalidEntityException("Password cannot be empty.");
        }
        if (password.length() < minimumLength) {
            throw new InvalidEntityException("Password too short. Minimum length is " + minimumLength);
        }
        if (password.length() > maximumLength) {
            throw new InvalidEntityException("Password too long. Maximum length is " + maximumLength);
        }
        if (StringUtils.isAlpha(password)){
            throw new InvalidEntityException("Password too weak. It mustn't contain only letters.");
        }
    }

    private void validateEmailAddress() throws InvalidEntityException {
        if (StringUtils.isEmpty(emailAddress)) {
            throw new InvalidEntityException("Email address cannot be empty.");
        }
        if (!EmailValidator.getInstance().isValid(emailAddress)) {
            throw new InvalidEntityException("Email address is not valid.");
        }
    }
}
