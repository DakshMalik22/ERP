package com.ERP.repositoriesTest;

import com.ERP.entitiesTest.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long>
{
     List<Project> findByName(String username);

}
