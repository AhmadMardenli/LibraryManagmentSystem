package com.task.Library.Management.System.controllers;

import com.task.Library.Management.System.models.Patron;
import com.task.Library.Management.System.services.PatronService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/patrons")
@Controller
public class PatronController {
    PatronService patronService;
    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Patron> getAll(){
        return patronService.getAll();
    }
    @GetMapping("/{id}")
    @ResponseBody
    public Patron getOne(@PathVariable long id){
        return patronService.getOne(id);
    }
    @PostMapping("")
    @ResponseBody
    public String create(@RequestParam String name,@RequestParam String information,@RequestParam String contact){
        return patronService.create(name,contact,information);
    }
    @PutMapping("/{id}")
    @ResponseBody
    public String update(@PathVariable long id,@RequestParam String name,@RequestParam String information,@RequestParam String contact){
        return patronService.update(name,contact,information,id);
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public String delete(@PathVariable long id){
        return patronService.delete(id);
    }
}
