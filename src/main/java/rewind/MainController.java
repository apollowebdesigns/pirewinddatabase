package rewind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/rewind") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private DirectionRepository directionRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam String time
            , @RequestParam String dir) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Direction direction = new Direction();
        direction.setTime(time);
        direction.setDirection(dir);
        directionRepository.save(direction);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Direction> getAllUsers() {
        // This returns a JSON or XML with the users
        return directionRepository.findAll();
    }
}