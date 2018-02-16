package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Connection.
 */
@Entity(name = "Connection")
@Table(name = "connections")
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int connectionId;

    @ManyToOne
    private User user;

    @Column(name = "linkedin_id")
    private int linkedInId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "number_connections")
    private int numberOfConnections;

    @Column(name = "is_updated")
    private boolean isUpdated;

    /**
     * Instantiates a new Connection.
     *
     * @param user the user
     */
    public Connection(User user) {
        this.user = user;
    }

    /**
     * Instantiates a new Connection.
     */
    public Connection() {
    }

    /**
     * Gets connection id.
     *
     * @return the connection id
     */
    public int getConnectionId() {
        return connectionId;
    }

    /**
     * Sets connection id.
     *
     * @param connectionId the connection id
     */
    public void setConnectionId(int connectionId) {
        this.connectionId = connectionId;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets linked in id.
     *
     * @return the linked in id
     */
    public int getLinkedInId() {
        return linkedInId;
    }

    /**
     * Sets linked in id.
     *
     * @param linkedInId the linked in id
     */
    public void setLinkedInId(int linkedInId) {
        this.linkedInId = linkedInId;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets number of connections.
     *
     * @return the number of connections
     */
    public int getNumberOfConnections() {
        return numberOfConnections;
    }

    /**
     * Sets number of connections.
     *
     * @param numberOfConnections the number of connections
     */
    public void setNumberOfConnections(int numberOfConnections) {
        this.numberOfConnections = numberOfConnections;
    }

    /**
     * Is updated boolean.
     *
     * @return the boolean
     */
    public boolean isUpdated() {
        return isUpdated;
    }

    /**
     * Sets updated.
     *
     * @param updated the updated
     */
    public void setUpdated(boolean updated) {
        isUpdated = updated;
    }



    @Override
    public String toString() {
        return "Connection{" +
                "connectionId=" + connectionId +
                ", user=" + user +
                ", linkedInId=" + linkedInId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", numberOfConnections=" + numberOfConnections +
                ", isUpdated=" + isUpdated +
                '}';
    }
}
