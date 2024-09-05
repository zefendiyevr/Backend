package com.medilink.backend.RegisterDevice;

import com.medilink.backend.ModelDto.Data;
import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import com.medilink.backend.ModelDto.RegisterDeviceResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterDeviceService  {
    @Autowired
    RegisterDeviceRepository registerDeviceRepository;

    public MedilinkResponsTmp registerDevice(String DeviceName, String DeviceUid,String Lang) {
        MedilinkResponsTmp medilinkResponsTmp = new MedilinkResponsTmp();
        Data data = new Data();
        medilinkResponsTmp.code = "200";
        medilinkResponsTmp.message = "Successuful!";
        medilinkResponsTmp.response = data;



        ArrayList<RegisterDeviceResponce> registerDeviceResponces = new ArrayList<>();



        List<?> deviceList =  registerDeviceRepository.getAllResult(DeviceName, DeviceUid,Lang);
         String item=deviceList.get(0).toString();
        registerDeviceResponces.add( new RegisterDeviceResponce(item));


        data.data = registerDeviceResponces;
        System.out.println(medilinkResponsTmp);
        System.out.println(registerDeviceRepository.getAllResult(DeviceName, DeviceUid, Lang));
        return medilinkResponsTmp;
    }


}
