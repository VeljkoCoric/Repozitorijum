package net.javaguides.springboot.repository;

import net.javaguides.springboot.controller.KorisnikController;
import net.javaguides.springboot.Model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    public default Korisnik findbyEmail(String Email) {
        KorisnikController korisnikController = new KorisnikController();
        Korisnik korisnik = korisnikController.getKorisnikByEmail(Email);
        return korisnik;
    }

    public default List<Korisnik> findAllKorisnik() {
        return findAll();
    }
}


