package com.employer.crud.exployercrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employer.crud.exployercrud.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel,Long>{

}
