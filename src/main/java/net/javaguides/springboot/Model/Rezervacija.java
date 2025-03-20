package net.javaguides.springboot.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Rezervacija")
public class Rezervacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long RezervacijaId;
    @ManyToOne
    @JoinColumn(name = "korisnikid")
    private Korisnik korisnik;
    @ManyToOne
    @JoinColumn(name = "racunar_id")
    private Racunar racunar;
    @Column(name = "Vreme_Rezervacije")
    private LocalDateTime vremeRezervacije;
    @Column(name = "Trajanje")
    private Integer trajanje;


}
