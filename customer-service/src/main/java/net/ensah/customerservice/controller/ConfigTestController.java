package net.ensah.customerservice.controller;

import net.ensah.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/config")
public class ConfigTestController {

    @Value("${global.params.x}")
    private int x;
    @Value("${global.params.y}")
    private int y;

    @Autowired
    private GlobalConfig globalConfig;

    @GetMapping
    public Map<String, String> getConfig() {
       Map<String, String> map = new HashMap<>();
       map.put("x", String.valueOf(x));
       map.put("y", String.valueOf(y));
       return map;
    }

    @GetMapping("/global")
    public GlobalConfig getGlobalConfig() {
        return globalConfig;
    }

}
