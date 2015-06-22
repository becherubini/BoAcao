package com.example.rafaelkrentz.androidparse;

import com.parse.ParseFile;
import com.parse.ParseGeoPoint;

import java.sql.Blob;

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
    private String phone;
    private String email;
    private ParseFile image;


    public Institute(String id, String name, String target, String cnpj, String address, ParseGeoPoint location, String phone, String email, ParseFile image) {
        this.id = id;
        this.name = name;
        this.target = target;
        this.cnpj = cnpj;
        this.address = address;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.image = image;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ParseFile getFile() {
        return image;
    }

    public void setFile(ParseFile image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return name;
    }
}

