package com.lukash.votingsystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurant", uniqueConstraints = {@UniqueConstraint(name = "restaurant_uniq_name", columnNames = "name")})
public class Restaurant extends AbstractNameEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Lunch> menu;

    public Restaurant() {
    }

    public Restaurant(final Integer id, final String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
