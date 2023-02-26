package com.example.CommerceBankProject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.*;

@Controller
public class MyController {
    Statement statement;

    public MyController() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/commerce", "root", "root");
        System.out.println("Database connected");
        statement = connection.createStatement();
    }

    @GetMapping("login")
    public String login(Model model, @ModelAttribute("username") String uname, @ModelAttribute("password") String pswd) throws SQLException {
        System.out.println(uname);
        System.out.println(pswd);

        ResultSet resultSet=statement.executeQuery("select * from users where username= '" + uname + "'" + " and password = '" + pswd + "'");

        String output = "";

        if (resultSet.wasNull()) {
            //Shows alert for wrong user
        }

        return "calendar";
    }
}
