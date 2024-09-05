package com.medilink.backend.HelpfulFunc;

public class _CheckPatientOrderNo {

    public Integer HospId;
    public Integer MemberId;
    public String OrdNo;
    public Integer getHospId() {
        return HospId;
    }

    public void setHospId(Integer hospId) {
        HospId = hospId;
    }

    public Integer getMemberId() {
        return MemberId;
    }

    public void setMemberId(Integer memberId) {
        MemberId = memberId;
    }

    public String getOrdNo() {
        return OrdNo;
    }

    public void setOrdNo(String ordNo) {
        OrdNo = ordNo;
    }


    public _CheckPatientOrderNo(Integer hospId, Integer memberId, String ordNo) {
        this.HospId = hospId;
        this.MemberId = memberId;
        this.OrdNo = ordNo;
    }


}
