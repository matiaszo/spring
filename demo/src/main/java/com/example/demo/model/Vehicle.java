package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Integer wheelCount;

    @Column
    private String typeVehicle;

    @Column
    private boolean isFourWheeled;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(Integer wheelCount) {
        this.wheelCount = wheelCount;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String type) {
        this.typeVehicle = type;
    }

    public boolean isIsFourWheeled() {
        return isFourWheeled;
    }

    public void setIsFourWheeled(boolean isFourWheeled) {
        this.isFourWheeled = isFourWheeled;
    }
}
