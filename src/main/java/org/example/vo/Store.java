package org.example.vo;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "store")
@Table(name = "stores")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Store {

    @Id
    String id;
    String name;
    @OneToMany(mappedBy = "store", fetch = FetchType.EAGER)
    List<Laptop> laptops = new ArrayList<Laptop>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

//    public Store(String id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}
