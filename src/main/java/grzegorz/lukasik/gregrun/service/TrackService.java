package grzegorz.lukasik.gregrun.service;

import grzegorz.lukasik.gregrun.model.Track;
import grzegorz.lukasik.gregrun.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class TrackService {
    private final TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public void addTrack(Track trackToAdd) {
        trackRepository.save(trackToAdd);
    }

    public Track findTrackById(long id){
        Optional<Track> optionalTrack = trackRepository.findById(id);
        return optionalTrack.orElseThrow(() -> new RuntimeException("Track with given id: '%s' not found"));
    }
    public long createRandomId() {
        return new Random().nextLong(1000);
    }

    public void removeTrackById(long id) {
        trackRepository.deleteById(id);
    }
}




