package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.Model.Racunar;
import net.javaguides.springboot.repository.RacunarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Racunar")

public class RacunarController {
    @Autowired
    private RacunarRepository racunarrepository;

    @GetMapping
    public List<Racunar> getAllARacunar(){
        return racunarrepository.findAll();

    }
    @PostMapping
    public Racunar createRacunar(@RequestBody Racunar racunar){
        return racunarrepository.save(racunar);
    }
    @GetMapping("{id}")
    public ResponseEntity<Racunar> getRacunarById(@PathVariable long id){
        Racunar racunar = racunarrepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Racunar ne postoji sa tim id-om: " + id));

        System.out.println(racunar.getNaziv() + "racunar je slobodan: " + racunar.isSlobodan());
        return ResponseEntity.ok(racunar);
    }
    @PutMapping("{id}")
    public ResponseEntity<Racunar> upadeteRacunar(@PathVariable long id, @RequestBody Racunar RacunarDetails) {
        Racunar updateRacunar = racunarrepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Racunar ne postoji sa tim id-om:" +id));
        updateRacunar.setSlobodan(RacunarDetails.isSlobodan());


        racunarrepository.save(updateRacunar);
        return ResponseEntity.ok(updateRacunar);

    }
    @DeleteMapping("{id}")
    public ResponseEntity <HttpStatus> deleteRacunar(@PathVariable long id){

        Racunar racunar = racunarrepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Racunar ne postoji sa tim id-om: "+id));
        racunarrepository.delete(racunar);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
