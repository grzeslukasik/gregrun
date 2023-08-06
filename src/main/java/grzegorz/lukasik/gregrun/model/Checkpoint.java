package grzegorz.lukasik.gregrun.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Checkpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private BigDecimal longitude;
    @Column
    private BigDecimal latitude;
    @ManyToOne
    private Track track;
}
