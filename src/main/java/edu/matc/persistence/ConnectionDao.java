package edu.matc.persistence;

import edu.matc.entity.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.*;
import java.util.List;

public class ConnectionDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     *  Gets all Connections
     *
     * @return all Connections
     */
    public List<Connection> getAllConnections() {
        logger.info("in get all Connections");
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Connection>  query = builder.createQuery(Connection.class);
        Root<Connection> root = query.from(Connection.class);
        List<Connection> connections = session.createQuery(query).getResultList();
        session.close();
        return connections;
    }

    public Connection getConnectionById(int id) {
        logger.debug("Searching for id: {}", id);
        Session session = sessionFactory.openSession();
        Connection connection = session.get(Connection.class, id);
        session.close();
        return connection;
    }


    /**
     * update Connection
     * @param connection  Connection to be inserted or updated
     */
    public void saveOrUpdate(Connection connection) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(connection);
        transaction.commit();
        session.close();
    }

    /**
     * update Connection
     * @param connection  Connection to be inserted or updated
     */
    public int insert(Connection connection) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(connection);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a Connection
     * @param connection connection to be deleted
     */
    public void delete(Connection connection) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(connection);
        transaction.commit();
        session.close();
    }


    /** Return a list of all Connections
     *
     * @return All Connections
     */
    public List<Connection> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Connection> query = builder.createQuery( Connection.class );
        Root<Connection> root = query.from( Connection.class );
        List<Connection> connections = session.createQuery( query ).getResultList();

        logger.debug("The list of Connections " + connections);
        session.close();

        return connections;
    }

    /**
     * Get Connection by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<Connection> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for Connection with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Connection> query = builder.createQuery( Connection.class );
        Root<Connection> root = query.from( Connection.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Connection> connections = session.createQuery( query ).getResultList();
        session.close();
        return connections;


    }

    /**
     * Get Connection by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<Connection> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for Connection with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Connection> query = builder.createQuery( Connection.class );
        Root<Connection> root = query.from( Connection.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Connection> connections = session.createQuery( query ).getResultList();

        session.close();
        return connections;


    }


}