package rewind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/rewind")
public class MainController {
    @Autowired
    private DirectionRepository directionRepository;

    /**
     * Adds data to database
     * @param time fixed currently
     * @param dir the endpoint to be called in the pirestservice
     * @return all current endpoints called
     */
    @CrossOrigin
    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody List<Direction> addNewUser (@RequestParam String time
            , @RequestParam String dir) {
        Direction direction = new Direction();
        direction.setTime(time);
        direction.setDirection(dir);
        directionRepository.save(direction);
        return getAllUsers();
    }

    /**
     * Clears out database, once Raspberry Pi has rewound
     */
    @CrossOrigin
    @GetMapping(path="/clear")
    public @ResponseBody void remove () {
        directionRepository.deleteAll();
    }


    /**
     * Gets current state of the Raspberry Pi's direction
     * @return Reverse of directions called
     */
    @CrossOrigin
    @GetMapping(path="/all")
    public @ResponseBody
    List<Direction> getAllUsers() {
        List<Direction> result = new ArrayList<>();
        directionRepository.findAll().forEach(result::add);
        return result;
    }
}