package com.lukash.votingsystem.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractNameEntity extends AbstractBaseEntity {

    protected String name;

    AbstractNameEntity() {
    }

    AbstractNameEntity(final Integer id, final String name) {
        super(id);
        this.name = name;
    }

    AbstractNameEntity(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AbstractNameEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
