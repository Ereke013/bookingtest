package kz.iitu.bookinghotels.controllers;


import kz.iitu.bookinghotels.entities.Entertainment;
import kz.iitu.bookinghotels.services.EntertainmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/entertainment")
public class EntertainmentController {
    @Autowired
    private EntertainmentService entertainmentService;

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllEntertainments() {
        return new ResponseEntity<>(this.entertainmentService.getAllList(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getEntertainmentById(@PathVariable(name = "id") Long id) {
        Entertainment entertainment = this.entertainmentService.getEntertainmentById(id);
        if (entertainment != null) {
            return ResponseEntity.ok(entertainment);
        }
        return null;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateEntertainment(@RequestBody Entertainment entertainment, @PathVariable(name = "id") Long id) {
        Entertainment entertainmentOld = this.entertainmentService.getEntertainmentById(id);
        if (entertainmentOld != null) {
            entertainmentOld.setName(entertainment.getName());
            entertainmentOld.setAdditional_cost(entertainment.getAdditional_cost());

            this.entertainmentService.saveEntertainment(entertainmentOld);
        }

        return ResponseEntity.ok(entertainmentOld);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteEntertainmentById(@PathVariable(name = "id") Long id) {
        Entertainment entertainment = this.entertainmentService.getEntertainmentById(id);
        if (entertainment != null) {
            this.entertainmentService.deleteEntertainment(entertainment);
            return ResponseEntity.ok(entertainment);
        }
        return null;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addEntertainment(@RequestBody Entertainment entertainment) {
        if (entertainment != null) {
            this.entertainmentService.saveEntertainment(entertainment);
            return new ResponseEntity<>(entertainment, HttpStatus.OK);
        }
        return null;
    }
}
