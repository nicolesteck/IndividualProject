package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Connection.
 */
@Entity(name = "Connection")
@Table(name = "connections")
@Getter
@Setter
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int connectionId;
//
//    @ManyToOne
//    private User user;

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

    @OneToMany(mappedBy = "connection", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<ActionItem> actionItems = new HashSet<>();


    @OneToMany(mappedBy = "connection", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<ConnectionJob> connectionJobs = new HashSet<>();

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
     *
     * @param user      the user
     * @param firstName the first name
     * @param lastName  the last name
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Connection that = (Connection) o;

        if (connectionId != that.connectionId) return false;
        if (linkedInId != that.linkedInId) return false;
        if (numberOfConnections != that.numberOfConnections) return false;
        if (isUpdated != that.isUpdated) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (relationship != null ? !relationship.equals(that.relationship) : that.relationship != null) return false;
        if (sharedInterests != null ? !sharedInterests.equals(that.sharedInterests) : that.sharedInterests != null)
            return false;
        if (background != null ? !background.equals(that.background) : that.background != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (headline != null ? !headline.equals(that.headline) : that.headline != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (industry != null ? !industry.equals(that.industry) : that.industry != null) return false;
        if (summary != null ? !summary.equals(that.summary) : that.summary != null) return false;
        if (specialties != null ? !specialties.equals(that.specialties) : that.specialties != null) return false;
        return profile != null ? profile.equals(that.profile) : that.profile == null;
    }

    @Override
    public int hashCode() {
        int result = connectionId;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + linkedInId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + numberOfConnections;
        result = 31 * result + (isUpdated ? 1 : 0);
        result = 31 * result + (relationship != null ? relationship.hashCode() : 0);
        result = 31 * result + (sharedInterests != null ? sharedInterests.hashCode() : 0);
        result = 31 * result + (background != null ? background.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (headline != null ? headline.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (industry != null ? industry.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (specialties != null ? specialties.hashCode() : 0);
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        return result;
    }
}
