package com.example.studyhtmx.controller;

import com.example.studyhtmx.entity.IotDevice;
import com.example.studyhtmx.service.IotDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("iot/onload")
@RequiredArgsConstructor
public class OnLoadController {

    private final IotDeviceService service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("devices", service.getDevices());
        return "iot/onload/index";
    }

    @GetMapping("{id}")
    public String deviceInfoPartial(@PathVariable long id,
                                    Model model) {
        IotDevice device = service.getDevice(id);
        model.addAttribute("device", device);
        model.addAttribute("deviceTemperature", service.getTemperature(device));
        return "iot/onload/partials :: device-info";
    }
}