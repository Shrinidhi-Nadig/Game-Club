package game.club.game.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import game.club.game.model.Game;
import game.club.game.repository.GameRepository;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameRepository gameRepository;
    @PostMapping
    public Game createGame(@RequestBody Game game) {
        game.setId(null);
        Game savedGame = gameRepository.save(game);
        return savedGame;
    }
    @GetMapping("path")
    public List<Game>findAll(){
        List<Game> game = gameRepository.findAll();
        return game;
    }
    @GetMapping("path/{id}")
    public Game findBYId(@PathVariable String id){
        Game game = gameRepository.findById(id).get();
        return game;
    }
    @PutMapping("path/{id}")
    public Game Update(@PathVariable String id, @RequestBody Game game) {
        Game oldGame = gameRepository.findById(id).get();
        oldGame.setName(game.getName());
        oldGame.setDescription(game.getDescription());
        oldGame.setPrice(game.getPrice());

        Game updatedGame = gameRepository.save(oldGame);
        return updatedGame; 
    }
    @DeleteMapping("path/{id}")
    public void delete(@PathVariable String id) {
        gameRepository.deleteById(id);
    }
    
}
