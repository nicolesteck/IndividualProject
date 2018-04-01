package edu.matc.entity;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
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


    @Column(name = "job_name")
    private String jobName;


    @Column(name = "company_name")
    private String companyName;


    @Column(name = "job_start")
    private Date jobStartDate;


    @Column(name = "job_end")
    private Date jobEndDate;


    @Column(name = "job_description")
    private String jobDescription;




}
