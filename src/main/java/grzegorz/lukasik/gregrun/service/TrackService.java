package grzegorz.lukasik.gregrun.service;

import grzegorz.lukasik.gregrun.model.Track;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TrackService{
    private List<Track> tracks = new ArrayList<>();

    public List<Track> getAll() {
        return tracks;
    }

    public void addTask(Track trackToAdd) {
        tracks.add(trackToAdd);
    }

    public Track findTrackById(long id){
        Optional<Track> optionalTrack = tracks.stream()
                .filter(track -> track.getId() == id)
                .findFirst();
        return optionalTrack.orElseThrow(() -> new RuntimeException("Track with given id: '%s' not found"));
    }
    public long createRandomId() {
        return new Random().nextLong(1000);
    }
}




