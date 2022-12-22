package ru.phoenixit.EntranceTest.phoenix.education.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.phoenixit.EntranceTest.phoenix.education.models.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
}
