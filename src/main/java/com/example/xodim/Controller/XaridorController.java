package com.example.xodim.Controller;

import com.example.xodim.Model.Xaridor;
import com.example.xodim.Service.XaridorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/xaridor")

public class XaridorController {

    @Autowired
    XaridorService service;

    @PostMapping("/insert")
    public String insert(@RequestBody Xaridor xaridor){
        return service.insert(xaridor);
    }

    @GetMapping
    public List<Xaridor> select(){
        return service.select();
    }


    @PutMapping("/update/{id}")
    public String update(@PathVariable Integer id, @RequestBody Xaridor xaridor){
        return service.update(id,xaridor);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        return service.delete(id);
    }


    @GetMapping("/{id}")
    public Xaridor getXaridorByid(@PathVariable Integer id){
        return service.getXaridorbyId(id);
    }
}
