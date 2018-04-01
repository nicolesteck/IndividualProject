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
@Entity(name = "ConnectionJob")
@Table(name = "connection_job")
@Getter
@Setter
public class ConnectionJob {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "id")
    private int jobId;


    @ManyToOne
    private Connection connection;

    
}
