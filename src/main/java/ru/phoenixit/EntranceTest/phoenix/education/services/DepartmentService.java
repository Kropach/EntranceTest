package ru.phoenixit.EntranceTest.phoenix.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.phoenixit.EntranceTest.phoenix.education.models.Department;
import ru.phoenixit.EntranceTest.phoenix.education.repositories.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Department findOne(Integer id){
        try {
            return departmentRepository.findById(id).get();
        } catch (NoSuchElementException e){
            return null;
        }
    }

    @Transactional
    public List<Department> findAll(){
        List<Department> departments = new ArrayList<>();
        try {
            departmentRepository.findAll().forEach(e -> departments.add(e));
        } catch (NullPointerException e){
            return null;
        }

        return departments;
    }

    @Transactional(rollbackFor = IllegalArgumentException.class)
    public String create(Department department){
        try {
            departmentRepository.save(department);
            return "Создан факультет";
        } catch (IllegalArgumentException e){
            return "Ошибка во время создания факультета";
        }
    }

    @Transactional(rollbackFor = IllegalArgumentException.class)
    public String delete(Integer id){
        try {
            departmentRepository.deleteById(id);
            return "Удален факультет";
        } catch (IllegalArgumentException e){
            return "Ошибка во время удаления факультета";
        }
    }

    @Transactional(rollbackFor = IllegalArgumentException.class)
    public String update(Integer id, Department updDepartment){
        try {
            Department department = departmentRepository.findById(id).get();
            department.setName(updDepartment.getName());
            department.setCode(updDepartment.getCode());
            departmentRepository.save(department);
            return "Факультет обновлен";
        } catch (IllegalArgumentException e){
            return "Ошибка во время обновления факультета";
        }
    }
}