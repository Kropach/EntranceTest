package ru.phoenixit.EntranceTest.phoenix.education.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.phoenixit.EntranceTest.phoenix.education.Service.DepartmentService;
import ru.phoenixit.EntranceTest.phoenix.education.models.Department;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @ResponseBody
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") int id){
        return departmentService.findOne(id);
    }

    @ResponseBody
    @GetMapping("/list")
    public List<Department> getDepartmentList(){
        return departmentService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.create(department), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        return new ResponseEntity<>(departmentService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestParam(name = "id") Integer id, @RequestBody Department department){
        return new ResponseEntity<>(departmentService.update(id, department), HttpStatus.OK);
    }
}