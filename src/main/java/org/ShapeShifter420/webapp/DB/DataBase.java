package org.ShapeShifter420.webapp.DB;

import org.ShapeShifter420.webapp.DB.models.*;
import org.ShapeShifter420.webapp.config.SpringConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.ShapeShifter420.webapp.DB.HBSessionUtil;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public static void save(Tables tables) {
        Session session = HBSessionUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(tables);
        tx1.commit();
        session.close();
    }

    public static void update(Tables tables) {
        Session session = HBSessionUtil.getSessionFactory().openSession();
        System.out.println(5);
        Transaction tx1 = session.beginTransaction();
        session.update(tables);
        System.out.println(6);
        tx1.commit();
        session.close();
    }
    public static List<Tables> getAllTables(){
        Session session = HBSessionUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<Tables> tablesList = (List<Tables>) session.createQuery("From Tables").list();
        session.close();
        return tablesList;
    }
    public static Menu findById(int id) {
        return HBSessionUtil.getSessionFactory().openSession().get(Menu.class, id);
    }
    public static List<Menu> findAll() {
        List<Menu> menu = (List<Menu>)  HBSessionUtil.getSessionFactory().openSession().createQuery("From menu").list();
        HBSessionUtil.getSessionFactory().close();
        return menu;
    }
    public static boolean checkAllready(int table_num){
        List<Tables> all = getAllTables();
        for (Tables t : all){
            if(t.getTable_num() == table_num && !t.getStat())
                return false;
        }
        return true;
    }
}
