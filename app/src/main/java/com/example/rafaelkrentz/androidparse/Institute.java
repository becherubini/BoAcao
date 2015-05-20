package com.example.rafaelkrentz.androidparse;

/**
 * Created by cherubiniNB on 18/05/2015.
 */
public class Institute {
    private int id;
    private String name;
    private String target;
    private String cnpj;
    private String address;

    public Institute(int id, String name, String target, String cnpj, String address) {
        this.id = id;
        this.name = name;
        this.target = target;
        this.cnpj = cnpj;
        this.address = address;
    }

    public Institute(String name, String target, String address) {
        this.name = name;
        this.target = target;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name;
    }
}

