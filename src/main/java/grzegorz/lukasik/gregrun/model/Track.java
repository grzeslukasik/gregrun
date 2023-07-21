package grzegorz.lukasik.gregrun.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "Date cannot be empty")
    @FutureOrPresent(message = "Task date is incorrect")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate trackDate;
    private List<Checkpoints> checkpointsList;
}
