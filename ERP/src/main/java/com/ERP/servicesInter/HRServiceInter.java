package com.ERP.servicesInter;

import com.ERP.entities.HR;
import com.ERP.exceptions.HRNotFoundException;

import java.util.List;

public interface HRServiceInter {
    public List<HR> fetchHRList();
    public HR fetchHRById(int hrId) throws HRNotFoundException;
    public HR addHR(HR hr);
    public void removeHR(int hrId);
    public HR updateHR(int hrId, HR hr);
}
