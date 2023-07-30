package grzegorz.lukasik.gregrun.repository;

import grzegorz.lukasik.gregrun.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {
}
