package service;

import dao.entities.Creator;
import dao.repositories.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreatorService implements CreatorManager{
    @Autowired
    private CreatorRepository creatorRepository;
    @Override
    public Creator addCreator(Creator creator) {
        try{
            return creatorRepository.save(creator);
        }catch (Exception exception){
            System.out.println(exception.getMessage()); //Logger
            return null;
        }
    }

    @Override
    public boolean deleteCreator(Creator creator) {
        return false;
    }

    @Override
    public boolean deleteCreatorById(Integer id) {
        return false;
    }

    @Override
    public Creator updateCreator(Creator creator) {
        return null;
    }

    @Override
    public List<Creator> getAllCreator() {
        return creatorRepository.findAll();
    }

    @Override
    public Creator getCreatorById(Integer id) {
        return creatorRepository.findById(id).get();
    }
}
