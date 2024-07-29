package com.medilink.backend.ModelDto;

public class RegisterStepTwoGetResponse {
    public String Surname;
    public String Name;
    public String  Middle;
    public String Birthday;
    public String Phone;
    public String GenderName;

    public RegisterStepTwoGetResponse(String surname, String name, String middle, String birthday, String phone, String genderName) {
        Surname = surname;
        Name = name;
        Middle = middle;
        Birthday = birthday;
        Phone = phone;
        GenderName = genderName;
    }



}
