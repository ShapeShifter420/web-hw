package org.ShapeShifter420.webapp;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.ShapeShifter420.webapp.DB.DataBase;
import org.ShapeShifter420.webapp.DB.models.Tables;
import org.ShapeShifter420.webapp.mailsender.MailSender;
import org.hibernate.annotations.Generated;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.UnsupportedEncodingException;

public class BronModel {
    private int table;
    private String email;
    private String time_begin;
    public boolean error = false;

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
        System.out.print(1);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        System.out.println(2);
    }
    public String getTime_begin() {
        return time_begin;
    }
    public void setTime_begin(String time_begin) {
        this.time_begin = time_begin;
        System.out.println(2);
    }

}
