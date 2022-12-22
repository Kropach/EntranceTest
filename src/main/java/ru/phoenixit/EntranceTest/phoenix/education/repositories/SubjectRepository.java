package ru.phoenixit.EntranceTest.phoenix.education.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.phoenixit.EntranceTest.phoenix.education.models.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
}
