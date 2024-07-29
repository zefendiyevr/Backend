package com.medilink.backend.RegisterDevice;

import com.medilink.backend.ModelDto.CheckConnectionRespons;
import com.medilink.backend.ModelDto.Data;
import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RegisterDeviceService  {
    @Autowired
    RegisterDeviceRepository registerDeviceRepository;

    public MedilinkResponsTmp registerDevice(String DeviceName, String DeviceUid) {
        MedilinkResponsTmp medilinkResponsTmp = new MedilinkResponsTmp();
        Data data = new Data();
        medilinkResponsTmp.code = "200";
        medilinkResponsTmp.message = "Successuful!";
        medilinkResponsTmp.response = data;
        ArrayList<CheckConnectionRespons> checkConnectionRespons = new ArrayList<>();
        checkConnectionRespons = (ArrayList<CheckConnectionRespons>) registerDeviceRepository.getAllResult(DeviceName, DeviceUid);
        data.data = checkConnectionRespons;
        System.out.println(medilinkResponsTmp);
        System.out.println(registerDeviceRepository.getAllResult(DeviceName, DeviceUid));
        return medilinkResponsTmp;
    }


}
