package es.bonboru.wheredidmymoneygo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="balance")
public class BalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="blc_invested")
    private Double invested;

    @Column(name="blc_bank")
    private Double bank;

    @Column(name="blc_cash")
    private Double cash;

}
