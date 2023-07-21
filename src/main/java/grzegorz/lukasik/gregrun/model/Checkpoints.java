package grzegorz.lukasik.gregrun.model;

import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Checkpoints {
    private BigDecimal longitude;
    private BigDecimal latitude;
}
