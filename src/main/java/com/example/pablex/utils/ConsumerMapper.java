package com.example.pablex.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.pablex.models.Consumer;

public class ConsumerMapper {
    

    public static Consumer resultSetToConsummer(ResultSet resultSet) throws SQLException {
        return new Consumer(resultSet.getInt("CONSUMERS_ID"), resultSet.getString("CONSUMERS_KEY"), resultSet.getString("CONSUMERS_FIRSTNAME"), resultSet.getString("CONSUMERS_LASTNAME"), resultSet.getBoolean("CONSUMERS_CHECK"));
    }

    public static List<Consumer> resultSetToListConsummer(ResultSet resultSet) throws SQLException {
        List<Consumer> list = new ArrayList<>();
        while(resultSet.next()) {
            list.add(ConsumerMapper.resultSetToConsummer(resultSet));
        }
        return list;
    }

}