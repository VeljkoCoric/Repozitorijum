package net.javaguides.springboot.repository;

import net.javaguides.springboot.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long > {

}
