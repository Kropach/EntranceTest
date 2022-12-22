package ru.phoenixit.EntranceTest.phoenix.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.phoenixit.EntranceTest.phoenix.education.models.Subject;
import ru.phoenixit.EntranceTest.phoenix.education.repositories.SubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Transactional
    public Subject findOne(Integer id){
        try {
            return subjectRepository.findById(id).get();
        } catch (NoSuchElementException e){
            return null;
        }
    }

    @Transactional
    public List<Subject> findAll(){
        List<Subject> subjects = new ArrayList<>();
        try {
            subjectRepository.findAll().forEach(e -> subjects.add(e));
        } catch (NullPointerException e){
            return null;
        }
        return subjects;
    }

    @Transactional(rollbackFor = IllegalArgumentException.class)
    public String create(Subject newSubject){
        try {
            subjectRepository.save(newSubject);
            return "Создан предмет";
        } catch (IllegalArgumentException e){
            return "Ошибка во время создания предмета";
        }
    }

    @Transactional(rollbackFor = IllegalArgumentException.class)
    public String delete(Integer id){
        try {
            subjectRepository.deleteById(id);
            return "Удален предмет";
        } catch (IllegalArgumentException e){
            return "Ошибка во время удаления предмета";
        }
    }

    @Transactional(rollbackFor = IllegalArgumentException.class)
    public String update(Integer id, Subject newSubject){
        try {
            Subject oldSubject = subjectRepository.findById(id).get();
            oldSubject.setName(newSubject.getName());
            oldSubject.setDepartment(newSubject.getDepartment());
            oldSubject.setDepartmentId(newSubject.getDepartment().getDepartmentId());
            oldSubject.setDuration(newSubject.getDuration());
            subjectRepository.save(oldSubject);
            return "Предмет обновлен";
        } catch (IllegalArgumentException e){
            return "Ошибка во время обновления предмета";
        }
    }
}
