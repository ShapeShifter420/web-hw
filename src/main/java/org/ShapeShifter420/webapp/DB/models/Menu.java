package org.ShapeShifter420.webapp.DB.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

    @Entity
    @Table (name = "menu")
    public class Menu {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(name = "name_of_position")
        private String name;
        private float cost;
        private String constituent;
        private float weight;


        public Menu() {
        }

        public Menu(String name, int age) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "models.User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" +
                    '}';
        }
    }

