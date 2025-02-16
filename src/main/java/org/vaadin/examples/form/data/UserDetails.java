package org.vaadin.examples.form.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

/**
 * Main Bean class that we build the form for.
 * <p>
 * Uses Bean Validation (JSR-303) annotations for automatic validation.
 */
@Entity
@DynamicUpdate
@Table(name="users")
public class UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Length(min = 1, max = 32)
    private String firstname;
    @NotNull
    @Length(min = 1, max = 32)
    private String lastname;

    @NotNull
    @Length(min = 4, max = 64)
    private String handle;

    private String avatar;

    @Email
    private String email;

    // FIXME Passwords should never be stored in plain text!
    @NotNull
    @Length(min = 8, max = 64)
    private String password;

    private boolean allowsMarketing;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAllowsMarketing() {
        return allowsMarketing;
    }

    public void setAllowsMarketing(boolean allowsMarketing) {
        this.allowsMarketing = allowsMarketing;
    }

    @Override
    public int hashCode() {
        if (id == null) {
            return super.hashCode();
        }
        return id.intValue();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (id == null) {
            return false;
        }
        if (!(obj instanceof UserDetails)) {
            return false;
        }
        UserDetails other = (UserDetails) obj;
        return id.equals(other.id);
    }
}