package kz.iitu.bookinghotels.controllers;


import kz.iitu.bookinghotels.entities.Services;
import kz.iitu.bookinghotels.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/services")
public class ServicesController {
    @Autowired
    private ServicesService servicesService;

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllServices() {
        return new ResponseEntity<>(this.servicesService.getAllList(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getServiceById(@PathVariable(name = "id") Long id) {
        Services service = this.servicesService.getServicesById(id);
        if (service != null) {
            return ResponseEntity.ok(service);
        }
        return null;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> updateService(@RequestBody Services service, @PathVariable(name = "id") Long id) {
        Services serviceOld = this.servicesService.getServicesById(id);
        if (serviceOld != null) {
            serviceOld.setService_name(service.getService_name());
            serviceOld.setService_type(service.getService_type());
            serviceOld.setAdditional_cost(service.getAdditional_cost());

            this.servicesService.updateServices(serviceOld);
        }

        return ResponseEntity.ok(serviceOld);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteServiceById(@PathVariable(name = "id") Long id) {
        Services serviceOld = this.servicesService.getServicesById(id);
        if (serviceOld != null) {
            this.servicesService.deleteServices(serviceOld);
            return ResponseEntity.ok(serviceOld);
        }
        return null;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addService(@RequestBody Services service) {
        if (service != null) {
            this.servicesService.addServices(service);
            return new ResponseEntity<>(service, HttpStatus.OK);
        }
        return null;
    }
}
