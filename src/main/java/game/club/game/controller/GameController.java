package game.club.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import game.club.game.model.Game;
import game.club.game.repository.GameRepository;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    // Create a new game
    @PostMapping
    public Game createGame(@RequestBody Game game) {
        game.setId(null); // ensure new entity
        return gameRepository.save(game);
    }

    // Get all games
    @GetMapping
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    // Get game by id
    @GetMapping("/{id}")
    public Game findById(@PathVariable String id) {
        return gameRepository.findById(id).orElse(null);
    }

    // Update game
    @PutMapping("/{id}")
    public Game update(@PathVariable String id, @RequestBody Game game) {
        Game oldGame = gameRepository.findById(id).orElseThrow();
        oldGame.setName(game.getName());
        oldGame.setDescription(game.getDescription());
        oldGame.setPrice(game.getPrice());
        return gameRepository.save(oldGame);
    }

    // Delete game
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        gameRepository.deleteById(id);
    }
}
