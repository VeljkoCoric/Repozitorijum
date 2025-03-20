package net.javaguides.springboot.controller;



import jakarta.validation.Valid;
import net.javaguides.springboot.Model.Korisnik;
import net.javaguides.springboot.Model.RegistracijaDto;
import net.javaguides.springboot.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountController {
   @Autowired
  private KorisnikRepository korisnikRepository;
   @Autowired
   private PasswordEncoder passwordEncoder;
   @GetMapping("/register")
   public String registracija(Model model){
      RegistracijaDto registracijaDto = new RegistracijaDto();
       model.addAttribute(registracijaDto);
      model.addAttribute("success", false);
       return "register";
    }
   @PostMapping("/register")
    public String registracija(
            Model model,
            @Valid @ModelAttribute RegistracijaDto registracijaDto,
           BindingResult result
        ) {
if (!registracijaDto.getSifra().equals(registracijaDto.getConfirmSifra())){
    result.addError(
           new FieldError("registracijaDto","confirmSifra"
           ,"Sifra i Confirm Sifra se ne poklapaju")
   );
}
Korisnik korisnik = null;
       List<Korisnik> lista = korisnikRepository.findAllKorisnik();
for(Korisnik k : lista){
    if(k.getEmail().equals(registracijaDto.getEmail())){
        korisnik = k;
    }
}
   if (korisnik!=null){
       result.addError(
              new FieldError("registracijaDto","Email"
                ,"Email adresa je vec iskoriscena.")
        );
    }
    if (result.hasErrors()) {
        return "register";
   }
    try{
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        Korisnik newkorisnik = new Korisnik();
        newkorisnik.setIme(registracijaDto.getIme());
        newkorisnik.setPrezime(registracijaDto.getPrezime());
        newkorisnik.setKorisnickoIme(registracijaDto.getKorisnickoIme());
        newkorisnik.setEmail(registracijaDto.getEmail());
        newkorisnik.setUloga("client");
        newkorisnik.setSifra(registracijaDto.getSifra());
      korisnikRepository.save(newkorisnik);
        model.addAttribute("success", true);
     model.addAttribute("registracijaDto", new RegistracijaDto());



    }
   catch (Exception ex){
        result.addError(
                (ObjectError) model.addAttribute("error","Doslo je do greske prilikom registracije: "));
       return "register";
    }
    return "register";
   }
}


