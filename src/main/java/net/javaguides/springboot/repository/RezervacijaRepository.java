package net.javaguides.springboot.repository;

import net.javaguides.springboot.Model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long > {
}
