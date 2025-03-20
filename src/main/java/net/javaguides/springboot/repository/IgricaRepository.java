package net.javaguides.springboot.repository;

import net.javaguides.springboot.Model.Igrica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IgricaRepository extends JpaRepository<Igrica, Long > {
}
