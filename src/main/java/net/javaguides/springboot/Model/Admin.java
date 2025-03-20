package net.javaguides.springboot.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Adminid;
    @Column(name = "Korisnicko_Ime", nullable = false)
    private String KorisnickoIme;
    @Column (name = "sifra", nullable = false)
    private String sifra;

}
