package es.bonboru.wheredidmymoneygo.model;

import es.bonboru.wheredidmymoneygo.enums.TypeMovementEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="movement")
public class MovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="mvt_date_creation")
    private OffsetDateTime dateCreation;

    @Column(name="mvt_date_modification")
    private OffsetDateTime dateModification;

    @Column(name="mvt_date_movement")
    private OffsetDateTime dateMovement;

    @Column(name="mvt_quantity")
    private Double quantity;

    @Column(name="mvt_reason")
    @Enumerated(EnumType.STRING)
    private TypeMovementEnum reason;

    @Column(name="mvt_subreason")
    private String subReason;

    @Column(name="mvt_necessary")
    private Boolean necessary;

}
