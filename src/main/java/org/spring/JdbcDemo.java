package org.spring;

import org.spring.dao.JdbcDaoImpl;
import org.spring.model.Circle;

public class JdbcDemo {

    public static void main(String[] args) {
        Circle circle = new JdbcDaoImpl().getCircle(1);
        System.out.println(circle.getName());
    }

}
