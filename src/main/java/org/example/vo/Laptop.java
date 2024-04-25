package org.example.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "laptop")
public class Laptop {
    @Id
    public String id;
    public String name;

    @ManyToOne
    public Store store;

    @Override
    public String toString() {
        return "Laptop{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
