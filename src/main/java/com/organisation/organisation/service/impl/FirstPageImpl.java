package com.organisation.organisation.service.impl;

import com.organisation.organisation.service.FirstPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstPageImpl implements FirstPage {

    private  String orgName;

    public FirstPageImpl(){
        this.orgName="Balaji Tiles Chirawa";
    }

    @Override
    public String getOrganisationName() {
        return orgName;
    }
}