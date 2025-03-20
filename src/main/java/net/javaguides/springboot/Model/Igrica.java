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
@Table(name = "Igrica")
public class Igrica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long IgricaId;
    @Column(name = "NazivIgrice")
    private String NazivIgrice;
}
