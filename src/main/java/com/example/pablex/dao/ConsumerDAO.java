package com.example.pablex.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pablex.models.Consumer;

@Repository
public class ConsumerDAO {

    private DataSource dataSource;

    @Autowired
	public ConsumerDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    public int save(Consumer consumer) throws SQLException {
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(
        "INSERT INTO CONSUMERS (CONSUMERS_FIRSTNAME, CONSUMERS_LASTNAME, CONSUMERS_CHECK,CONSUMERS_KEY)" +
        "VALUES (?,?,?,?) ");
        preparedStatement.setString(1,consumer.getFirstName());
        preparedStatement.setString(2,consumer.getLastName());
        preparedStatement.setBoolean(3,consumer.isCheck());
        preparedStatement.setString(4,consumer.getKey());
        return preparedStatement.executeUpdate();
    }

    public boolean saveAll(List<Consumer> consumers) throws SQLException {
        boolean bool = true;
        for(Consumer consumer : consumers) {
            if(this.save(consumer) != 1) {
                bool = false;
            }
        }
        return bool;
    }

    public ResultSet findById(int consumerID) throws SQLException {
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement("SELECT * FROM CONSUMERS WHERE CONSUMERS_ID = ?");
        preparedStatement.setInt(1,consumerID);
        return preparedStatement.executeQuery();
    }

    public ResultSet findByKey(String clientKey) throws SQLException {
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement("SELECT * FROM CONSUMERS WHERE CONSUMERS_KEY = ?");
        preparedStatement.setString(1,clientKey);
        return preparedStatement.executeQuery();
    }

    public ResultSet findAll() throws SQLException {
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement("SELECT * FROM CONSUMERS");
        return preparedStatement.executeQuery();
    }

    public int update(Consumer consumer) throws SQLException {
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(
        "UPDATE CONSUMERS SET " + 
            "CONSUMERS_FIRSTNAME = ? ," + 
                "CONSUMERS_LASTNAME = ? ," + 
                    "CONSUMERS_CHECK = ? ," + 
                        "CONSUMERS_KEY = ? WHERE CONSUMERS_ID = ?");
        preparedStatement.setString(1,consumer.getFirstName());
        preparedStatement.setString(2,consumer.getLastName());
        preparedStatement.setBoolean(3,consumer.isCheck());
        preparedStatement.setString(4,consumer.getKey());
        preparedStatement.setInt(5,consumer.getId());
        return preparedStatement.executeUpdate();
    }

    public int updateCheckByID(int clientID,boolean isCheck) throws SQLException {
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement("UPDATE CONSUMERS SET CONSUMERS_CHECK = ? WHERE CONSUMERS_ID = ?");
        preparedStatement.setBoolean(1,isCheck);
        preparedStatement.setInt(2,clientID);
        return preparedStatement.executeUpdate();
    }

    public int deleteByID(int clientID) throws SQLException {
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement("DELETE FROM CONSUMERS WHERE CONSUMERS_ID = ?");
        preparedStatement.setInt(1,clientID);
        return preparedStatement.executeUpdate();
    }

    public int deleteAll() throws SQLException {
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement("DELETE FROM CONSUMERS");
        return preparedStatement.executeUpdate();
    }
    
}
