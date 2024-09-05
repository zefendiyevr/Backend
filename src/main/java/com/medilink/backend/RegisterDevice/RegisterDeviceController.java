package com.medilink.backend.RegisterDevice;

import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/")
public class RegisterDeviceController {

    @Autowired
    public RegisterDeviceService registerDeviceService;

    @PostMapping("/registerdevice")
    public MedilinkResponsTmp RegisterDevice(@RequestHeader String CurrentDatetime, @RequestHeader String Nonce, String Token ,
                                             @RequestBody DeviceRegister deviceRegister) {
        return registerDeviceService.registerDevice(deviceRegister.DeviceName, deviceRegister.DeviceUid, deviceRegister.Lang);

    }
}