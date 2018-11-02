package com;

import com.domain.Server;
import com.repos.ServerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private ServerRepo serverRepo;

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Server> servers = serverRepo.findAll();
        model.put("servers", servers);
        return "main";
    }
    @PostMapping
    public String add(@RequestParam String serverName,
                      @RequestParam String serverAddress,
                      Map<String,Object> model
                      ){
        Server server = new Server(serverName,serverAddress);

        serverRepo.save(server);
        Iterable<Server> servers = serverRepo.findAll();
        String vers = null;
        try {
            vers = server.getVersion();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(vers == null){
            model.put("version", "null, sorry");
        } else {
            model.put("version", vers);
        }
        model.put("servers", servers);


        return "main";
    }

}
