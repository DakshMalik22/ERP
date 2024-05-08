package com.ERP.repositoriesTest;

import com.ERP.entitiesTest.HR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HRRepository extends JpaRepository<HR, Integer> {

}
