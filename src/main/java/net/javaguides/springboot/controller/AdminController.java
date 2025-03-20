package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.Model.Admin;
import net.javaguides.springboot.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")

public class AdminController {

    @Autowired
    private AdminRepository adminrepository;

    @GetMapping
    public List<Admin> getAllAdmins(){
        return adminrepository.findAll();

    }
    @PostMapping
    public Admin createadmin(@RequestBody Admin admin){
        return adminrepository.save(admin);
    }
    @GetMapping("{id}")
    public ResponseEntity <Admin> getAdminById(@PathVariable long id){
        Admin admin = adminrepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin ne postoji sa tim id-om: " + id));
        System.out.println(admin.getKorisnickoIme());
        return ResponseEntity.ok(admin);
    }
    @PutMapping("{id}")
    public ResponseEntity<Admin> upadeteAdmin(@PathVariable long id, @RequestBody Admin AdminDetails) {
        Admin updateAdmin = adminrepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin ne postoji sa tim id-om:" +id));
        updateAdmin.setKorisnickoIme(AdminDetails.getKorisnickoIme());
        updateAdmin.setSifra(AdminDetails.getSifra());

        adminrepository.save(updateAdmin);
        return ResponseEntity.ok(updateAdmin);

    }
    @DeleteMapping("{id}")
    public ResponseEntity <HttpStatus> deleteAdmin(@PathVariable long id){

        Admin admin = adminrepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Admin ne postoji sa tim id-om: "+id));
        adminrepository.delete(admin);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
