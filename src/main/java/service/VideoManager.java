package service;

import dao.entities.Video;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface VideoManager {
    public Video addVideo(Video video);
    public boolean deleteVideo(Video video);
    public boolean deleteVideoById(Integer id);
    public Video updateVideo(Video video);
    public List<Video> getAllVideo();
    public Video getVideoById(Integer id);
}
