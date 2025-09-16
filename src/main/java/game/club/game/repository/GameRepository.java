package game.club.game.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import game.club.game.model.Game;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {
    // Custom query methods can be defined here if needed

    
}