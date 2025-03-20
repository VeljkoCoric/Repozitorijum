package net.javaguides.springboot.controller;



import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.Model.Igrica;
import net.javaguides.springboot.repository.IgricaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Igrica")
public class IgricaController {
    @Autowired
    private IgricaRepository igricarepository;

    @GetMapping
    public List<Igrica> getAllIgrica() {
        return igricarepository.findAll();
    }
    @PostMapping
    public Igrica createigrica(@RequestBody Igrica igrica) {
        return igricarepository.save(igrica);

    }
    @GetMapping("{id}")
    public ResponseEntity<Igrica> getIgricaById(@PathVariable long id){
        Igrica igrica = igricarepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Igrica ne postoji sa tim id-om: " + id));
        System.out.println(igrica.getNazivIgrice());
        return ResponseEntity.ok(igrica);
    }

    @DeleteMapping("{id}")
    public ResponseEntity <HttpStatus> deleteIgrica(@PathVariable long id){

        Igrica igrica = igricarepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Igrica ne postoji sa tim id-om: "+id));
        igricarepository.delete(igrica);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
