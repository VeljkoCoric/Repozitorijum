package net.javaguides.springboot.controller;


import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.Model.Korisnik;
import net.javaguides.springboot.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/korisnik")
public class KorisnikController {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @GetMapping
    public List<Korisnik> getAllKorisnik(){
        return korisnikRepository.findAllKorisnik();

    }
    @GetMapping("/create")
    public Korisnik createKorisnik(@RequestBody Korisnik korisnik){
        return korisnikRepository.save(korisnik);

    }
    @GetMapping("/log/{Email}")
    public Korisnik getKorisnikByEmail(@PathVariable String Email) {
        System.out.println("test");
        Korisnik k = null;
        List<Korisnik> lista = getAllKorisnik();
        for(Korisnik kor : lista)
            if(kor.getEmail().equals(Email)){
                k = kor;
            }
        return k;
    }


    @GetMapping("{id}")
    public ResponseEntity<Korisnik> getKorisnikById(@PathVariable long id){
        Korisnik korisnik = korisnikRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Korisnik ne postoji sa tim id-om: " + id));
        System.out.println(korisnik.getKorisnickoIme());
        return ResponseEntity.ok(korisnik);
    }
    @GetMapping("/update/{id}")
    public ResponseEntity<Korisnik> upadeteKorisnik(@PathVariable long id, @RequestBody Korisnik KorisnikDetails) {
        System.out.println("test");
        Korisnik updateKorisnik = korisnikRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Korisnik ne postoji sa tim id-om:" +id));
        updateKorisnik.setKorisnickoIme(KorisnikDetails.getKorisnickoIme());
        updateKorisnik.setSifra(KorisnikDetails.getSifra());

        korisnikRepository.save(updateKorisnik);
        return ResponseEntity.ok(updateKorisnik);

    }
    @GetMapping("/delete/{id}")
    public ResponseEntity <HttpStatus> deleteKorisnik(@PathVariable long id){

        Korisnik korisnik = korisnikRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Korisnik ne postoji sa tim id-om: "+id));
        korisnikRepository.delete(korisnik);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
