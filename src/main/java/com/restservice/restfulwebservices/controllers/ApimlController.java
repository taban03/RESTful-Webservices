package com.restservice.restfulwebservices.controllers;

import com.ca.mfaas.eurekaservice.model.Health;
import com.restservice.restfulwebservices.model.EmptyJsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.spring.web.plugins.Docket;

@Controller
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class ApimlController {


//    customize location for swagger
//    @GetMapping("/api-doc")
//    public String apiDoc() {
//        return "forward:/v2/api-docs";
//    }

    @GetMapping("/application/health")
    public @ResponseBody Health getHealth() {
        return new Health("UP");
    }

    @GetMapping("/application/info")
    public @ResponseBody ResponseEntity<EmptyJsonResponse> getDiscoveryInfo() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");
        return new ResponseEntity<>(new EmptyJsonResponse(), headers, HttpStatus.OK);
    }
}
