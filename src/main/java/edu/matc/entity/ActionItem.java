package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

/**
 * The type Connection.
 */
@Entity(name = "ActionItem")
@Table(name = "action_items")
@Getter
@Setter
public class ActionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int actionItemId;


    @ManyToOne
    private Connection connection;


    @ManyToOne
    private User user;

    @Column(name = "action_item_name")
    private String actionItemName;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "is_complete")
    private Boolean isComplete;

    @Column(name = "date_completed")
    private Date dateCompleted;

    /**
     * Instantiates a new Action item.
     */
    public ActionItem() {
    }

    /**
     * Instantiates a new Action item.
     *
     * @param connection     the connection
     * @param user           the user
     * @param actionItemName the action item name
     * @param dateCreated    the date created
     */
    public ActionItem(Connection connection, User user, String actionItemName, Date dateCreated) {
        this.connection = connection;
        this.user = user;
        this.actionItemName = actionItemName;
        this.dateCreated = dateCreated;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionItem that = (ActionItem) o;

        if (actionItemId != that.actionItemId) return false;
        if (connection != null ? !connection.equals(that.connection) : that.connection != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (actionItemName != null ? !actionItemName.equals(that.actionItemName) : that.actionItemName != null)
            return false;
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null) return false;
        if (isComplete != null ? !isComplete.equals(that.isComplete) : that.isComplete != null) return false;
        return dateCompleted != null ? dateCompleted.equals(that.dateCompleted) : that.dateCompleted == null;
    }

    @Override
    public int hashCode() {
        int result = actionItemId;
        result = 31 * result + (connection != null ? connection.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (actionItemName != null ? actionItemName.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (isComplete != null ? isComplete.hashCode() : 0);
        result = 31 * result + (dateCompleted != null ? dateCompleted.hashCode() : 0);
        return result;
    }
}