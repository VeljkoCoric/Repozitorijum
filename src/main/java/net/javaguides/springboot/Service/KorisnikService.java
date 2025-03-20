package net.javaguides.springboot.Service;


import lombok.extern.slf4j.Slf4j;
import net.javaguides.springboot.Model.Korisnik;
import net.javaguides.springboot.controller.KorisnikController;
import net.javaguides.springboot.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;


@Slf4j
@Service
public class KorisnikService implements UserDetailsService{
    @Autowired
    private KorisnikController korisnikController;
    private KorisnikRepository korisnikRepository;
    private UserDetailsService userDetailsService;
    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
        Korisnik korisnik;
        korisnik = korisnikController.getKorisnikByEmail(Email);
        if(korisnik != null){

                UserDetails springKorisnik = Korisnik.withUsername(korisnik.getEmail())
                        .username(korisnik.getEmail())
                        .password(korisnik.getSifra())
                        .roles(korisnik.getUloga())
                        .build();
                return springKorisnik;
        }
        return null;
    }


}
