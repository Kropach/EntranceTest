package ru.phoenixit.EntranceTest.phoenix.education.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.phoenixit.EntranceTest.phoenix.education.Service.ClassService;
import ru.phoenixit.EntranceTest.phoenix.education.models.Class;

import java.util.List;

@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @ResponseBody
    @GetMapping("/{id}")
    public Class getClass(@PathVariable("id") Integer id){
        return classService.findOne(id);
    }

    @ResponseBody
    @GetMapping("/list")
    public List<Class> getClassList(){
        return classService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Class newClass){
        return new ResponseEntity<>(classService.create(newClass), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        return new ResponseEntity<>(classService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestParam(name = "id") Integer id, @RequestBody Class newClass){
        return new ResponseEntity<>(classService.update(id, newClass), HttpStatus.OK);
    }
}
