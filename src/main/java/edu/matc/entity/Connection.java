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

    /**
     * Instantiates a new Connection.
     *
     * @param user the user
     */
    public Connection(User user) {
        this.user = user;
    }

    public Connection(User user, String firstName, String lastName) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getSharedInterests() {
        return sharedInterests;
    }

    public void setSharedInterests(String sharedInterests) {
        this.sharedInterests = sharedInterests;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
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
