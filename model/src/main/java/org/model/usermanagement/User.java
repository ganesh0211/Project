package org.model.usermanagement;


import org.usermanagement.core.model.impl.ObserverCoreImpl;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 11/5/16
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "USER")
public class User extends ObserverCoreImpl {

    private String firstName;
    private String lastName;
    private String middleName;
    private String username;
    private String password;
    private String contactEmail;
    private String contactNumber;
    @ManyToOne(targetEntity = Role.class)
    private Role role;
    @ManyToOne(targetEntity = User.class)
    private User manager;
    @ManyToOne(targetEntity = UserGroup.class)
    private UserGroup userGroup;

    public String getFirstName() {
        return firstName;
    }

    public String setFirstName(String firstName) {
        this.firstName = firstName;
        return this.firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String setLastName(String lastName) {
        this.lastName = lastName;
        return this.lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String setMiddleName(String middleName) {
        this.middleName = middleName;
        return this.middleName;
    }

    public String getUsername() {
        return username;
    }

    public String setUsername(String username) {
        this.username = username;
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        this.password = password;
        return this.password;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
        return this.contactEmail;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
        return this.contactNumber;
    }

    public Role getRole() {
        return role;
    }

    public Role setRole(Role role) {
        this.role = role;
        return this.role;
    }


    public User getManager() {
        return manager;
    }

    public User setManager(User manager) {
        this.manager = manager;
        return this.manager;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    @Override
    public void notifyUpdate() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (!contactEmail.equals(user.contactEmail)) return false;
        if (!contactNumber.equals(user.contactNumber)) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        if (!middleName.equals(user.middleName)) return false;
        if (!password.equals(user.password)) return false;
        if (!username.equals(user.username)) return false;
        if (!role.equals(user.role)) return false;
        if (!manager.equals(user.manager)) return false;
        if (!userGroup.equals(user.userGroup)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = (firstName != null) ? 31 * result + firstName.hashCode() : result;
        result = (lastName != null) ? 31 * result + lastName.hashCode() : result;
        result = (middleName != null) ? 31 * result + middleName.hashCode() : result;
        result = (username != null) ? 31 * result + username.hashCode() : result;
        result = (password != null) ? 31 * result + password.hashCode() : result;
        result = (contactEmail != null) ? 31 * result + contactEmail.hashCode() : result;
        result = (contactNumber != null) ? 31 * result + contactNumber.hashCode() : result;
        result = (role != null) ? 31 * result + role.hashCode() : result;
        result = (manager != null) ? 31 * result + manager.hashCode() : result;
        result = (userGroup != null) ? 31 * result + userGroup.hashCode() : result;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", password='" + password + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", role='" + role + '\'' +
                ", manager='" + manager + '\'' +
                ", userGroup='" + userGroup + '\'' +
                "} " + super.toString();
    }
}
