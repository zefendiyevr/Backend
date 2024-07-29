package com.medilink.backend.ModelDto;

public class HospitalListResponse {

    public int id;
    public String name;


    public HospitalListResponse(int id, String name) {
        this.id = id;
        this.name = name;
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
        name = name;
    }


}
