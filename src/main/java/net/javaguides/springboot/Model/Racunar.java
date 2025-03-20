package net.javaguides.springboot.Model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Racunar")
public class Racunar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long RacunarId;
    @Column(name = "Naziv_Racunara", nullable = false)
    private String Naziv;
    @Column(name = "Status")
    private boolean Slobodan;
}
