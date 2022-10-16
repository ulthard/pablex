package com.example.pablex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pablex.dao.ConsumerDAO;
import com.example.pablex.models.Consumer;

import java.util.List;
import java.sql.SQLException;

@Service
public class ConsumerService {
    
    @Autowired
    private ConsumerDAO consumerDAO;

    public boolean save(Consumer consumer) throws SQLException{
        return this.consumerDAO.save(consumer) == 1;
    }

    public boolean saveAll(List<Consumer> consumers) throws SQLException {
        this.consumerDAO.saveAll(consumers);
        return true;
    }

    public Consumer findById(int consumerID) throws SQLException {
        return this.consumerDAO.findById(consumerID);
    }

    public Consumer findByKey(String clientKey) throws SQLException {
        return this.consumerDAO.findByKey(clientKey);
    }

    public List<Consumer> findAll() throws SQLException {
        return this.consumerDAO.findAll();
    }

    public boolean update(Consumer consumer) throws SQLException {
        this.consumerDAO.update(consumer);
        return true;
    }

    public boolean updateCheckByID(int clientID,boolean isCheck) throws SQLException {
        return this.consumerDAO.updateCheckByID(clientID,isCheck) == 1;
    }

    public boolean deleteByID(int clientID) throws SQLException {
        return this.consumerDAO.deleteByID(clientID) == 1;
    }

    public boolean deleteAll() throws SQLException {
        return this.consumerDAO.deleteAll() == 1;
    }

}
