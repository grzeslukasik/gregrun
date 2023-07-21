package grzegorz.lukasik.gregrun.controller;

import grzegorz.lukasik.gregrun.model.Track;
import grzegorz.lukasik.gregrun.service.TrackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TrackController {

    private List<Track> trackList = new ArrayList<>();
    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/tracks")
    public String getTracks(Model model) {
        Track emptyTrack = new Track();
        model.addAttribute("track", emptyTrack);

        List<Track> tracks = trackService.getAll();
        model.addAttribute("tracks", tracks);
        return "tracks/track";
    }

    @GetMapping("/tracks/create")
    public String schowCreateForm(Model model){
        model.addAttribute("track", new Track());
        return "tracks/add-track";
    }

    @PostMapping("/tracks")
    public String createTrack(@Valid @ModelAttribute Track track, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "tracks/add-track";
        }
        track.setId(trackService.createRandomId());
        trackService.addTask(track);
        return "redirect:/tracks";
    }

    @GetMapping("/tracks/{id}/checkpoints")
    public String getCheckpoints(@PathVariable("id") long id, Model model) {
        Track track = trackService.findTrackById(id);

        if (track == null) {
            model.addAttribute("errorMessage", "Track not found!");
            return "error";
        }
        model.addAttribute("track", track);
        return "tracks/checkpoints";
    }
}
