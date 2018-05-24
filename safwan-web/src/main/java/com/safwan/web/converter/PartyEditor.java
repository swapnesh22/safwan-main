package com.safwan.web.converter;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safwan.data.model.PartyMaster;
import com.safwan.services.service.PartyService;

@Component
public class PartyEditor extends PropertyEditorSupport 

{
	@Autowired
	PartyService partyService;
    //This will be called when user HTTP Post to server a field bound to DepartmentVO

    @Override
    public void setAsText(String id) 
    {
    	
    	PartyMaster party = partyService.findPartyById(Long.valueOf(id));
        this.setValue(party);
    }

}
