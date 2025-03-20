package net.javaguides.springboot.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor


public class RegistracijaDto {
    @NotEmpty
    private String Ime;
    @NotEmpty
    private String Prezime;
    @NotEmpty
    private String korisnickoIme;
    @NotEmpty
    @Email
    private String Email;
    @Size(min = 5, message = "Najmanja duzina sifre je 5 karaktera.")
    private String sifra;
    private String confirmSifra;

    public String getIme() {
        return Ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getEmail() {
        return Email;
    }

    public String getSifra() {
        return sifra;
    }

    public String getConfirmSifra() {
        return confirmSifra;
    }

    public void setIme(String ime) {
        Ime = ime;
    }

    public void setPrezime(String prezime) {
        Prezime = prezime;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public void setConfirmSifra(String confirmSifra) {
        this.confirmSifra = confirmSifra;
    }

}
