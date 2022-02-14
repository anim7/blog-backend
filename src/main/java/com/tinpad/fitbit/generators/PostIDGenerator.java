package com.tinpad.fitbit.generators;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class PostIDGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(@NotNull SharedSessionContractImplementor session, Object object)
            throws HibernateException {

        StringBuilder prefix = new StringBuilder("post");
        Connection connection = session.connection();

        try {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select count(post_id) as Id from posts");

            if (rs.next()) {
                int id = rs.getInt(1) + 101;
                int lengthOfZeros = 5 - Integer.toString(id).length();
                prefix.append("0".repeat(Math.max(0, lengthOfZeros)));
                return prefix.toString() + id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}