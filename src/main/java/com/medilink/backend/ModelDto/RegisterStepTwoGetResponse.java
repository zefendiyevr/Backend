package com.medilink.backend.ModelDto;

public class RegisterStepTwoGetResponse {
    public  String FullName;
    public String Surname;
    public String Name;
    public String  Middle;
    public String Birthday;
    public String Phone;
    public String GenderName;
    public String Pid;
    public  String Rid;

    public RegisterStepTwoGetResponse(String fullName,String surname, String name, String middle, String birthday, String phone, String genderName, String pId, String rid) {
        FullName=fullName;
        Surname = surname;
        Name = name;
        Middle = middle;
        Birthday = birthday;
        Phone = phone;
        GenderName = genderName;
        Pid=pId;
        Rid=rid;
    }



}
