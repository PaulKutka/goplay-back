package com.example.goplay.controllers;


import com.example.goplay.beans.response.LeadboardResponse;
import com.example.goplay.services.LeadboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/leadboard")
public class LeadboardController {

    @Autowired
    private LeadboardService leadboardService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<LeadboardResponse> getLeadboard()
    {
        return leadboardService.getLeadboard();
    }
}
