package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

/**
 * The type UserConnection.
 */
@Entity(name = "ActionItem")
@Table(name = "action_items")
@Getter
@Setter
public class UserConnection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int userConnectionId;

    @ManyToOne
    private Connection connectionForLinking;

    @ManyToOne
    private User user;

    @ManyToOne
    private ActionItem actionItem;

    /**
     * Instantiates a new Action item.
     */
    public UserConnection() {
    }

    /**
     * Instantiates a new Action item.
     *
     * @param connection     the connection
     * @param user           the user
     * @param actionItem the action item
     * @param dateCreated    the date created
     */
    public UserConnection(Connection connection, User user, ActionItem actionItem, Date dateCreated) {
        this.connection = connection;
        this.user = user;
        this.actionItem = actionItem;
        this.dateCreated = dateCreated;
    }


    /**
     * Instantiates a new User connection.
     *
     * @param connection the connection
     * @param user       the user
     */
    public UserConnection(Connection connection, User user) {
        this.connection = connection;
        this.user = user;
    }


}