package ru.phoenixit.EntranceTest.phoenix.education.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.phoenixit.EntranceTest.phoenix.education.models.Class;
import ru.phoenixit.EntranceTest.phoenix.education.repositories.ClassRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    @Transactional
    public Class findOne(Integer id){
        try {
            return classRepository.findById(id).get();
        } catch (NoSuchElementException e){
            return null;
        }
    }

    @Transactional
    public List<Class> findAll(){
        List<Class> classes = new ArrayList<>();
        try {
            classRepository.findAll().forEach(e -> classes.add(e));
        } catch (NullPointerException e){
            return null;
        }
        return classes;
    }

    @Transactional(rollbackFor = IllegalArgumentException.class)
    public String create(Class newClass){
        try {
            classRepository.save(newClass);
            return "Создан предмет";
        } catch (IllegalArgumentException e){
            return "Ошибка во время создания предмета";
        }
    }

    @Transactional(rollbackFor = IllegalArgumentException.class)
    public String delete(Integer id){
        try {
            classRepository.deleteById(id);
            return "Удален предмет";
        } catch (IllegalArgumentException e){
            return "Ошибка во время удаления предмета";
        }
    }

    @Transactional(rollbackFor = IllegalArgumentException.class)
    public String update(Integer id, Class newClass){
        try {
            Class oldClass = classRepository.findById(id).get();
            oldClass.setName(newClass.getName());
            oldClass.setDepartment(newClass.getDepartment());
            oldClass.setDepartmentId(newClass.getDepartment().getDepartmentId());
            oldClass.setDuration(newClass.getDuration());
            classRepository.save(oldClass);
            return "Предмет обновлен";
        } catch (IllegalArgumentException e){
            return "Ошибка во время обновления предмета";
        }
    }
}
