package com.organisation.organisation.contoller;

import com.organisation.organisation.service.FirstPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testing {
    @Autowired
    private FirstPage firstPage;

    @RequestMapping("/hello")
    public String getHello(){
        return firstPage.getOrganisationName();
    }

}
