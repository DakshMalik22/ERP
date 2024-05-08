package com.ERP.controllers;

import com.ERP.entities.HR;
import com.ERP.exceptions.HRNotFoundException;
import com.ERP.servicesInter.HRServiceInter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HRController {

    @Autowired
    private HRServiceInter hrService;

    @GetMapping("/hr")
    public List<HR> getHR(){
        return hrService.fetchHRList();
    }
    @PostMapping("/addHR")
    public HR addHR(@Valid @RequestBody HR hr){
        return hrService.addHR(hr);
    }
    @GetMapping("/hr/{id}")
    public HR getHRById(@PathVariable("id") int hrId) throws HRNotFoundException {
        return hrService.fetchHRById(hrId);
    }
    @DeleteMapping("removeHR/{id}")
    public void removeHR(@PathVariable("id") int hrId){
        hrService.removeHR(hrId);
    }

    @PutMapping("/updateHR/{id}")
    public HR updateHR(@PathVariable("id") int hrId,
                                                 @RequestBody HR hr) {
        return hrService.updateHR(hrId, hr);
    }
}
