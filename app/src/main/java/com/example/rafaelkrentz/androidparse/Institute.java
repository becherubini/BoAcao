package com.example.rafaelkrentz.androidparse;

import com.parse.ParseGeoPoint;

/**
 * Created by cherubiniNB on 18/05/2015.
 */
public class Institute {
    private String id;
    private String name;
    private String target;
    private String cnpj;
    private String address;
    private ParseGeoPoint location;

    public Institute(String id, String name, String target, String cnpj, String address, ParseGeoPoint location) {
        this.id = id;
        this.name = name;
        this.target = target;
        this.cnpj = cnpj;
        this.address = address;
        this.location = location;
    }

    public Institute(String id, String name, String target, String address) {
        this.id = id;
        this.name = name;
        this.target = target;
        this.address = address;
    }

    public Institute() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public ParseGeoPoint getLocation() {
        return location;
    }
    public void setLocation(ParseGeoPoint location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return name;
    }
}

