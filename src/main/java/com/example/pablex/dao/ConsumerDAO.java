package com.example.pablex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pablex.models.Consumer;
import com.example.pablex.utils.ConsumerMapper;

@Repository
public class ConsumerDAO {

    private DataSource dataSource;

    @Autowired
	public ConsumerDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}

    public int save(Consumer consumer) throws SQLException {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CONSUMERS (CONSUMERS_FIRSTNAME, CONSUMERS_LASTNAME, CONSUMERS_CHECK,CONSUMERS_KEY)" +
                "VALUES (?,?,?,?) ")) {
                preparedStatement.setString(1,consumer.getFirstName());
                preparedStatement.setString(2,consumer.getLastName());
                preparedStatement.setBoolean(3,consumer.isCheck());
                preparedStatement.setString(4,consumer.getKey());
                return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
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

    public Consumer findById(int consumerID) throws SQLException {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CONSUMERS WHERE CONSUMERS_ID = ?")) {
                preparedStatement.setInt(1,consumerID);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                return ConsumerMapper.resultSetToConsummer(resultSet);
        } catch (SQLException e) {
            throw e;
        }
    }

    public Consumer findByKey(String clientKey) throws SQLException {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CONSUMERS WHERE CONSUMERS_KEY = ?")) {
                preparedStatement.setString(1,clientKey);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.next();
                return ConsumerMapper.resultSetToConsummer(resultSet);
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Consumer> findAll() throws SQLException {
        try (Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CONSUMERS ORDER BY CONSUMERS_FIRSTNAME ASC")) {
                return ConsumerMapper.resultSetToListConsummer(preparedStatement.executeQuery());
        } catch (SQLException e) {
            throw e;
        }
    }

    public int update(Consumer consumer) throws SQLException {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE CONSUMERS SET " + 
            "CONSUMERS_FIRSTNAME = ? ," + 
                "CONSUMERS_LASTNAME = ? ," + 
                    "CONSUMERS_CHECK = ? ," + 
                        "CONSUMERS_KEY = ? WHERE CONSUMERS_ID = ?")) {
                preparedStatement.setString(1,consumer.getFirstName());
                preparedStatement.setString(2,consumer.getLastName());
                preparedStatement.setBoolean(3,consumer.isCheck());
                preparedStatement.setString(4,consumer.getKey());
                preparedStatement.setInt(5,consumer.getId());
                return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public int updateCheckByID(int clientID,boolean isCheck) throws SQLException {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE CONSUMERS SET CONSUMERS_CHECK = ? WHERE CONSUMERS_ID = ?")) {
                preparedStatement.setBoolean(1,isCheck);
                preparedStatement.setInt(2,clientID);
                return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public int deleteByID(int clientID) throws SQLException {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM CONSUMERS WHERE CONSUMERS_ID = ?")) {
                preparedStatement.setInt(1,clientID);
                return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public int deleteAll() throws SQLException {
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM CONSUMERS")) {
                return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
    
}
