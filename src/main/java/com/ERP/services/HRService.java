package com.ERP.services;

import com.ERP.entities.HR;
import com.ERP.exceptions.HRNotFoundException;
import com.ERP.repositories.HRRepository;
import com.ERP.servicesInter.HRServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HRService implements HRServiceInter {
    @Autowired
    private HRRepository hrRepository;

    @Override
    public List<HR> fetchHRList() {
        return hrRepository.findAll();
    }
    @Override
    public HR fetchHRById(int hrId) throws HRNotFoundException {
        Optional<HR> hr = hrRepository.findById(hrId);
        if(!hr.isPresent()){
            throw new HRNotFoundException("HR Not Available");
        }
        return hr.get();
    }
    @Override
    public HR addHR(HR hr) {
        return hrRepository.save(hr);
    }
    @Override
    public void removeHR(int hrId) {
        hrRepository.deleteById(hrId);
    }

    @Override
    public HR updateHR(int hrId, HR hr){
        HR hr1 = hrRepository.findById(hrId).get();

        if(Objects.nonNull(hr.getName()) &&
                !"".equalsIgnoreCase(hr.getName())){
            hr1.setName(hr.getName());
        }

        if(Objects.nonNull(hr.getPassword()) &&
                !"".equalsIgnoreCase(hr.getPassword())){
            hr1.setPassword(hr.getPassword());
        }

        if(Objects.nonNull(hr.getRole()) &&
                !"".equals(hr.getRole())){
            hr1.setRole(hr.getRole());
        }
        return hrRepository.save(hr1);
    }
}
