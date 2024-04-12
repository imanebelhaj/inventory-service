package ma.xproce.inventoryservice;

import dao.entities.Creator;
import dao.entities.Video;
import dao.repositories.CreatorRepository;
import dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import service.CreatorManager;
import service.VideoManager;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    // @Bean
    public CommandLineRunner startDAO(CreatorRepository creatorRepository, VideoRepository videoRepository){
        return args -> {
            Creator creator1 = new Creator();
            creator1.setName("creaotr1");
            creator1.setEmail("creator1@gmail.com");
            //creator1.setVideos(startDAOVideo());

            // Enregistrer le créateur dans la base de données
            creatorRepository.save(creator1);

            Creator creator2 = new Creator();
            creator2.setName("creaotr2");
            creator2.setEmail("creatorq@gmail.com");
            //creator2.setVideos(startDAOVideo());

            // Enregistrer le créateur dans la base de données
            creatorRepository.save(creator2);

            Creator savedCreator1 = creatorRepository.findByName("creaotr1").orElseThrow();
            Creator savedCreator2 = creatorRepository.findByName("creaotr2").orElseThrow();

            Video video1 = new Video();
            video1.setName("video1");
            video1.setUrl("https....");
            video1.setCreator(savedCreator1);
            video1.setDescription("first video");
            video1.setDatePublication("Day 1");

            Video video2 = new Video();
            video2.setName("video2");
            video2.setUrl("https....");
            video2.setCreator(savedCreator2);
            video2.setDescription("second video");
            video2.setDatePublication("Day 2");
            videoRepository.saveAll(List.of(video1, video2));



        };
    }
    public CommandLineRunner startServiceCreator(CreatorManager creatorManager, VideoManager videoManager){
        return args -> {
            Creator creator1 = new Creator();
            creator1.setName("creaotr1");
            creator1.setEmail("creator1@gmail.com");
            //creator1.setVideos(startDAOVideo());

            Creator creator2 = new Creator();
            creator2.setName("creaotr2");
            creator2.setEmail("creatorq@gmail.com");
            //creator2.setVideos(startDAOVideo());

            Video video1 = new Video();
            video1.setName("video1");
            video1.setUrl("https....");
            //video.setCreator(1);
            video1.setDescription("first video");
            video1.setDatePublication("Day 1");

            Video video2 = new Video();
            video2.setName("video2");
            video2.setUrl("https....");
            //video2.setCreator(2);
            video2.setDescription("second video");
            video2.setDatePublication("Day 2");
            videoManager.addVideo(video1);
            videoManager.addVideo(video2);


        };
    }
}
