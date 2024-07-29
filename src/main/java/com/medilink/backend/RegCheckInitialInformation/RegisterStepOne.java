package com.medilink.backend.RegCheckInitialInformation;

public class RegisterStepOne {
    public  String  RegTime ;    //yyyy-mm-dd hh:mm:sss
    public String  IpAdd ;       //device Ip adsress` VARCHAR(32) - App-in bizə bağlandığı IP adresidir. Back end də təyin edilir.
    public Integer DevId ;       // INT - RegDevice servisində Appa-ə göndərilmiş  DeviceId dir
    public Integer HospId;        // INT - Seçilmiş tibb müəssisəsi ID sisidr.
    public String ReferralVal ;   //VARCHAR(6) - Klinika operatoruna (istifadəçiyə) verilmiş xüsusi 6 rəgəm/hərfli koddur.

    public String FinCode;        //VARCHAR(7) - Tibb müəssisəsində qeydiyyatdan keçmiş və app istifadə edəcək pasinetin Ş.V. fin kodudur.public int OrdNo;         // Yuxaırda qeyd edilmiş pasinetin klinikadakı sifariş nömrəsidir
    public  Integer OrdNo;
    public Integer getOrdNo() {
        return OrdNo;
    }

    public void setOrdNo(Integer ordNo) {
        OrdNo = ordNo;
    }


    public RegisterStepOne(String regTime, String ipAdd, Integer devId, Integer hospId, String referralVal, String finCode, Integer ordNo) {
        RegTime = regTime;
        IpAdd = ipAdd;
        DevId = devId;
        HospId = hospId;
        ReferralVal = referralVal;
        FinCode = finCode;
        OrdNo=ordNo;
    }


    public String getRegTime() {
        return RegTime;
    }

    public void setRegTime(String regTime) {
        RegTime = regTime;
    }

    public String getIpAdd() {
        return IpAdd;
    }

    public void setIpAdd(String ipAdd) {
        IpAdd = ipAdd;
    }

    public Integer getDevId() {
        return DevId;
    }

    public void setDevId(Integer devId) {
        DevId = devId;
    }

    public Integer getHospId() {
        return HospId;
    }

    public void setHospId(Integer hospId) {
        HospId = hospId;
    }

    public String getReferralVal() {
        return ReferralVal;
    }

    public void setReferralVal(String referralVal) {
        ReferralVal = referralVal;
    }

    public String getFinCode() {
        return FinCode;
    }

    public void setFinCode(String finCode) {
        FinCode = finCode;
    }




}
