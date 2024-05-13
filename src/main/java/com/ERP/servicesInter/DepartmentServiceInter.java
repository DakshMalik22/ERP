package com.ERP.servicesInter;

import com.ERP.dtos.DepartmentDto;
import com.ERP.dtos.ProjectDto;

import java.util.List;

public interface DepartmentServiceInter
{

    DepartmentDto addDepartment(DepartmentDto departmentDto);
    DepartmentDto updateDepartment(DepartmentDto departmentDto,long departmentId);
    DepartmentDto deleteDepartment(long departmentId);
    DepartmentDto findDepartment(long departmentId);
    List<DepartmentDto> addAllDepartment(List<DepartmentDto> departmentDtos);
    List<DepartmentDto> findAllDepartment();
}
