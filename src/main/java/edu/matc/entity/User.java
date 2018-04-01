package edu.matc.entity;


import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent a user.
 *
 * @author nsteck based on code from pawaite   userId int  pk   first_name varchar(25)   last_name varchar(25)   email varchar(30)   password varchar(30)   li_password varchar(30)
 */
@Entity(name = "User")
@Table(name = "user") /// case sensitive
@Getter
@Setter
public class User {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "number_connections")
    private int numConnections;

    @Column(name = "is_updated")
    private boolean isUpdated;

    @Column(name = "relationship")
    private String relationship;

    @Column(name = "shared_interests")
    private String sharedInterests;

    @Column(name = "background")
    private String background;

    @Column(name = "notes")
    private String notes;

    @Column(name = "headline")
    private String headline;

    @Column(name = "location")
    private String location;

    @Column(name = "industry")
    private String industry;

    @Column(name = "summary")
    private String summary;

    @Column(name = "specialties")
    private String specialties;

    @Column(name = "profile")
    private String profile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Connection> connections = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<ActionItem> actionItems = new HashSet<>();


    @Id//the GeneratedValue and GenericGenerator are to create an auto-generating key
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id; // didn't need to specify a column name since the column in the DB
    // is the same as the prop name

    // WARNING: only use EAGER if there will only ever be a very low number of "many" records
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter @Setter private Set<Role> roles = new HashSet<Role>();

    /**
     * Instantiates a new User.
     */
    public User() {
        isUpdated = false;
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        isUpdated = false;
    }


    /**
     * Gets connections.
     *
     * @return the connections
     */
    public Set<Connection> getConnections() {
        return connections;
    }

    /**
     * Sets connections.
     *
     * @param connections the connections
     */
    public void setConnections(Set<Connection> connections) {
        this.connections = connections;
    }

    /**
     * Add connection.
     *
     * @param connection the connection
     */
    public void addConnection(Connection connection) {
        connections.add(connection);
        connection.setUser(this);
    }

    /**
     * Remove connection.
     *
     * @param connection the connection
     */
    public void removeConnection(Connection connection) {
        connections.remove(connection);
        connection.setUser(null);
    }

    public void setUpdated(boolean isUpdated) {
        this.isUpdated = isUpdated;
    }

    public boolean getUpdated() {
        return isUpdated;
    }


    /**
     * Add role.
     *
     * @param role the role
     */
    public void addRole(Role role) {
        roles.add(role);
        role.setUser(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}