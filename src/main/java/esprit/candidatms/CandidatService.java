package esprit.candidatms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatService {

    @Autowired
    private CandidatRepository candidatRepository;
    // Simulons un cache en mémoire pour les jobs reçus
    private List<JobDTO> favoriteJobDTOS = new ArrayList<>();
    private static final Logger log = LoggerFactory.getLogger(CandidatService.class);
    public void receiveJobService(JobDTO jobDTO) {
        log.info("Traitement du jobDTO received : {}", jobDTO.getService());
        addJobToFavorites(jobDTO);
        sendNotificationToUser(jobDTO);
    }
    private void addJobToFavorites(JobDTO jobDTO) {
        // Ajoutons le JobDTO à la liste en mémoire (cachée)
        favoriteJobDTOS.add(jobDTO);
        log.info("JobDTO ajouté aux favoris : {}", jobDTO.getService());
    }
    private void sendNotificationToUser(JobDTO jobDTO) {
        // Simulation de l'envoi d'une notification
        log.info("Notification envoyée au candidat: Nouveau jobDTO - {}",
                jobDTO.getService());
    }
    // Simulez l'affichage des jobs favoris depuis le cache
    public List<JobDTO> getFavoriteJobs() {
        return favoriteJobDTOS;
    }
    public List<Candidat> getAllCandidats() {
        return candidatRepository.findAll();
    }
}
