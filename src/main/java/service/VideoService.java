package service;

import dao.entities.Video;
import dao.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VideoService implements VideoManager{

    @Autowired
    private VideoRepository videoRepository;
    @Override
    public Video addVideo(Video video) {
        try{
            return videoRepository.save(video);
        }catch (Exception exception){
            System.out.println(exception.getMessage()); //Logger
            return null;
        }
    }

    @Override
    public boolean deleteVideo(Video video) {
        return false;
    }

    @Override
    public boolean deleteVideoById(Integer id) {
        return false;
    }

    @Override
    public Video updateVideo(Video video) {
        return null;
    }

    @Override
    public List<Video> getAllVideo() {
        return videoRepository.findAll();
    }

    @Override
    public Video getVideoById(Integer id) {
        return videoRepository.findById(id).get();
    }
}
