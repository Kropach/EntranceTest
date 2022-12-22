package ru.phoenixit.EntranceTest.phoenix.education.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.phoenixit.EntranceTest.phoenix.education.services.SubjectService;
import ru.phoenixit.EntranceTest.phoenix.education.models.Subject;

import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @ResponseBody
    @GetMapping("/{id}")
    public Subject getSubject(@PathVariable("id") Integer id){
        return subjectService.findOne(id);
    }

    @ResponseBody
    @GetMapping("/list")
    public List<Subject> getSubjectList(){
        return subjectService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Subject newSubject){
        return new ResponseEntity<>(subjectService.create(newSubject), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        return new ResponseEntity<>(subjectService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestParam(name = "id") Integer id, @RequestBody Subject newSubject){
        return new ResponseEntity<>(subjectService.update(id, newSubject), HttpStatus.OK);
    }
}
