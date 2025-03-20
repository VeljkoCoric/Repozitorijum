package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.Model.Racunar;
import net.javaguides.springboot.Model.Rezervacija;
import net.javaguides.springboot.repository.KorisnikRepository;
import net.javaguides.springboot.repository.RacunarRepository;
import net.javaguides.springboot.repository.RezervacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Rezervacija")

public class RezervacijaController {
    @Autowired
    private RezervacijaRepository rezervacijarepository;
    @Autowired
    private RacunarRepository racunarrepository;
    @Autowired
    private KorisnikRepository korisnikrepository;

    @GetMapping
    public List<Rezervacija> getAllRezervacija(){
        return rezervacijarepository.findAll();
    }

    @PostMapping
    public Rezervacija createrezervacija(@RequestBody Rezervacija rezervacija) {
        long korisnikid = rezervacija.getKorisnik().getKorisnikid();
        long racunarid = rezervacija.getRacunar().getRacunarId();

        if (rezervacija.getKorisnik() == null) {
            throw new ResourceNotFoundException("Korisnik ne postoji.");
        }
        Racunar racunar = new Racunar();
        if (rezervacija.getRacunar() == null) {
            throw  new ResourceNotFoundException ("Računar nije pronađen.");
        }
        if (rezervacija.getRacunar().isSlobodan()) {
            throw new ResourceNotFoundException("Računar je vec zauzet.");
        }

        Rezervacija novaRezervacija = new Rezervacija();
        novaRezervacija.setKorisnik(rezervacija.getKorisnik());
        novaRezervacija.setRacunar(rezervacija.getRacunar());
        novaRezervacija.setVremeRezervacije(LocalDateTime.now());
        novaRezervacija.setTrajanje(rezervacija.getTrajanje());
        return rezervacijarepository.save(novaRezervacija);
    }



    @GetMapping("{id}")
    public ResponseEntity<Rezervacija> getRezervacijaById(@PathVariable long id){
        Rezervacija rezervacija = rezervacijarepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rezervacija ne postoji sa tim id-om: " + id));

        System.out.println(rezervacija);
        return ResponseEntity.ok(rezervacija);

    }

    @PutMapping("{id}")
    public ResponseEntity<Rezervacija> upadeteRezervacija(@PathVariable long id, @RequestBody Rezervacija RezervacijaDetails) {
        Rezervacija updateRezervacija = rezervacijarepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rezervacija ne postoji sa tim id-om:" + id));
             korisnikrepository.findById(RezervacijaDetails.getKorisnik().getKorisnikid())
                .orElseThrow(() -> new ResourceNotFoundException("Korisnik ne postoji sa tim id-om:" + id));
             racunarrepository.findById(RezervacijaDetails.getRacunar().getRacunarId())
                .orElseThrow(() -> new ResourceNotFoundException("Racunar ne postoji sa tim id-om:" + id));

            updateRezervacija.setKorisnik(RezervacijaDetails.getKorisnik());
            updateRezervacija.setRacunar(RezervacijaDetails.getRacunar());
            updateRezervacija.setVremeRezervacije(RezervacijaDetails.getVremeRezervacije());
            updateRezervacija.setTrajanje(RezervacijaDetails.getTrajanje());
        rezervacijarepository.save(updateRezervacija);
        return ResponseEntity.ok(updateRezervacija);


    }

    @DeleteMapping("{id}")
    public ResponseEntity <HttpStatus> deleteRezervacija(@PathVariable long id){

        Rezervacija rezervacija = rezervacijarepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Rezervacija ne postoji sa tim id-om: "+id));
        rezervacijarepository.delete(rezervacija);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
