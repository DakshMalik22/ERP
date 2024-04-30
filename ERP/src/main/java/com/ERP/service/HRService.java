package com.ERP.service;

import com.ERP.entity.HR;
import com.ERP.error.HRNotFoundException;

import java.util.List;

public interface HRService {
    public List<HR> fetchHRList();
    public HR fetchHRById(int hrId) throws HRNotFoundException;
    public HR addHR(HR hr);
    public void removeHR(int hrId);
    public HR updateHR(int hrId, HR hr);
}
