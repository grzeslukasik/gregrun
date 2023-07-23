package grzegorz.lukasik.gregrun.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    @Column
    private String trackName;
    @Column
    private String trackDescription;
//    @NotNull(message = "Date cannot be empty")
//    @FutureOrPresent(message = "Task date is incorrect")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "track_date")
    private LocalDate trackDate;
    @OneToMany(mappedBy = "track")
    private List<Checkpoints> checkpointsList;
}
