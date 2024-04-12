package dao.repositories;

import dao.entities.Video;
import dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Integer> {

}
