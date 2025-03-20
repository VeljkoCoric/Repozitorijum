package net.javaguides.springboot.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "Korisnik")
public class Korisnik  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Korisnikid;
    @Column(name ="Ime", nullable = false)
    private String Ime;
    @Column(name = "Prezime", nullable = false)
    private String Prezime;

    @Column(name = "Email", unique = true,nullable = false)
    @Email
    private String Email;
    @Column(name = "Korisnicko_Ime", nullable = false)
    private String KorisnickoIme;
    @Column(name = "sifra", nullable = false)
    private String sifra;
    @Column(name = "Uloga")
    private String uloga;

    public Korisnik(long korisnikid, String ime, String prezime, String email, String korisnickoIme, String sifra, String uloga) {
        Korisnikid = korisnikid;
        Ime = ime;
        Prezime = prezime;
        Email = email;
        KorisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.uloga = uloga;
    }

    public static User.UserBuilder withUsername(String email) {
        return null;
    }


    public long getKorisnikid() {
        return Korisnikid;
    }

    public String getIme() {
        return Ime;
    }

    public String getEmail() {
        return Email;
    }

    public String getPrezime() {
        return Prezime;
    }

    public String getKorisnickoIme() {
        return KorisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public String getUloga() {
        return uloga;
    }

    public void setKorisnikid(long korisnikid) {
        Korisnikid = korisnikid;
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

    public void setKorisnickoIme(String korisnickoIme) {
        KorisnickoIme = korisnickoIme;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }


}

