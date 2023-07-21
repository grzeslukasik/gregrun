package grzegorz.lukasik.gregrun.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Track {
    private long id;
    private String trackName;
    private String trackDescription;
    private LocalDate trackDate;
    private List<Checkpoints> checkpointsList;
}
