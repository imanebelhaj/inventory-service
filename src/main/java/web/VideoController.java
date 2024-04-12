package web;

import dao.entities.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.VideoManager;

import java.util.List;

@Controller
public class VideoController {
    @Autowired
    private VideoManager videoManager;

    // Afficher la liste des vidéos
    @GetMapping("/list")
    public String showVideoList(Model model) {
        List<Video> videos = videoManager.getAllVideo();
        model.addAttribute("videos", videos);
        return "videoList"; // Affiche la vue videoList.html
    }


    @GetMapping("/add")
    public String showAddVideoForm(Model model) {
        model.addAttribute("video", new Video());
        return "addVideo"; // Affiche la vue addVideo.html
    }

    // Ajouter une nouvelle vidéo
    @PostMapping("/add")
    public String addVideo(@ModelAttribute("video") Video video) {
        videoManager.addVideo(video);
        return "redirect:/videos/list";
    }

    // Afficher le formulaire de modification d'une vidéo
    @GetMapping("/edit/{id}")
    public String showEditVideoForm(@PathVariable("id") Integer id, Model model) {
        Video video = videoManager.getVideoById(id);
        model.addAttribute("video", video);
        return "editVideo"; // Affiche la vue editVideo.html
    }

    // Modifier une vidéo déjà existante
    @PostMapping("/edit/{id}")
    public String updateVideo(@PathVariable("id") Integer id, @ModelAttribute("video") Video video) {
        video.setId(id);
        videoManager.updateVideo(video);
        return "redirect:/videos/list";
    }





}
