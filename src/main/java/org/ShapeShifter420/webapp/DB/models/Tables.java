package org.ShapeShifter420.webapp.DB.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "tables")
public class Tables {
    @Id
    private int table_num;
    @Column(name = "reg_name")
    private String name;
    private String time_begin;
    private boolean stat = false;
    private int reg_number;

    public Tables() {
    }

    public Tables(int table_num,String name, boolean stat,String time_begin) {
        this.name = name;
        this.stat = stat;
        this.reg_number = name.hashCode()+table_num;
        this.time_begin = time_begin;
        this.table_num = table_num;

    }

    public String getName() {
        return name;
    }
    public int getTable_num(){return table_num;}
    public void setName(String name) {
        this.name = name;
    }
    public String getTime_begin(){return time_begin;}
    public void setStat(boolean stat){this.stat=stat;}
    public int getReg_number(){return reg_number;}
    public boolean getStat() {
        return stat;
    }
}