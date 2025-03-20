package net.javaguides.springboot;

import net.javaguides.springboot.Service.KorisnikService;
import net.javaguides.springboot.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private KorisnikRepository korisnikRepository;
	@Autowired
	private IgricaRepository igricarepository;
	@Autowired
	private RacunarRepository racunarrepository;
	@Autowired
	private RezervacijaRepository rezervacijarepository;
	@Autowired
	 private UserDetailsService userDetailsService;
	@Autowired
	private KorisnikService korisnikService;



	@Override
	public void run(String... args) throws Exception {


		}




}

