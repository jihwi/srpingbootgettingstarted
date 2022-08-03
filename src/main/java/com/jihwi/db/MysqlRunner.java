package com.jihwi.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

//@Component
public class MysqlRunner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    Logger logger = LoggerFactory.getLogger(MysqlRunner.class);

    @Override
    public void run(ApplicationArguments args) {
        try (Connection connection = dataSource.getConnection()){
            logger.debug(dataSource.getClass().toString());
            logger.debug(connection.getMetaData().getURL());
            logger.debug(connection.getMetaData().getUserName());

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE SPRING(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (ID))";
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.debug("done");

//        기본 jdbc사용보다 jdbcTemplate사용이 용이함 (커넥션 리턴이라던지 )
        jdbcTemplate.execute("INSERT INTO SPRING VALUES (2, 'jihwi')");
    }
}
