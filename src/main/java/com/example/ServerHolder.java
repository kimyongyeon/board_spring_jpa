package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yongyeonkim on 2016. 5. 30..
 */
@Component
@ConfigurationProperties(locations="classpath:server.yml")
public class ServerHolder {

    public Map<String, Map<String, String>> servers = new HashMap<String, Map<String, String>>();

    public Map<String, Map<String, String>> getServers() {
        return servers;
    }

}
