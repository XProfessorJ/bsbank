package com.bs.servicezuul.dao.impl;

import com.bs.servicezuul.dao.CustomerDao;
import com.bs.servicezuul.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public CustomerEntity findCustomerByPhoneAndPassword(String phone, String password) {
        String sql = "select * from customer where phone = ? and password = ?";
        try {
            CustomerEntity customerEntity = jdbcTemplate.queryForObject(sql, new Object[]{phone, password}, new RowMapper<CustomerEntity>() {
                @Override
                public CustomerEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                    CustomerEntity customer = new CustomerEntity();
                    customer.setCustomerId(resultSet.getString("customerId"));
                    customer.setCustomerType(resultSet.getString("customerType"));
                    customer.setNames(resultSet.getString("names"));
                    customer.setGender(resultSet.getString("gender"));
                    customer.setPrefix(resultSet.getString("prefix"));
                    customer.setSuffix(resultSet.getString("suffix"));
                    customer.setCustomerSegment(resultSet.getString("customerSegment"));
                    customer.setPartnerCustomerSegment(resultSet.getString("partnerCustomerSegment"));
                    customer.setPhone(resultSet.getString("phone"));
                    customer.setEmail(resultSet.getString("email"));
                    customer.setPassword(resultSet.getString("password"));
                    return customer;
                }
            });
            return customerEntity;
        } catch (Exception e){
            return null;
        }

    }

}
