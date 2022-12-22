package ru.phoenixit.EntranceTest.phoenix.education.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.phoenixit.EntranceTest.phoenix.education.models.Class;

public interface ClassRepository extends CrudRepository<Class, Integer> {
}
