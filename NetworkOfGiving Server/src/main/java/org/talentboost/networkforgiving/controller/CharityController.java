package org.talentboost.networkforgiving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.talentboost.networkforgiving.model.Charity;
import org.talentboost.networkforgiving.service.CharityService;
import org.talentboost.networkforgiving.utils.AuthenticationUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "charity")
public class CharityController {
    @Autowired
    private CharityService charityService;

    @Autowired
    private AuthenticationUtil authenticationUtil;

    @GetMapping("/{id}")
    public ResponseEntity getCharity(@PathVariable int id) {
        return ResponseEntity.ok(charityService.getCharity(id));
    }

    @GetMapping
    public List<Charity> getAll() {
        return charityService.getAll();
    }

    @PostMapping
    public ResponseEntity addCharity(@RequestBody Charity charity) {
        return ResponseEntity.ok(charityService.createCharity(charity));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCharity(@PathVariable int id, @RequestBody Charity charity) {
//        if (!authenticationHandler.isAuthenticated(request)) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }

        charityService.updateCharity(id, charity);
        return ResponseEntity.ok(charity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCharity(HttpServletRequest request, @PathVariable int id) {
        if (!authenticationUtil.isAuthenticated(request)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        this.charityService.deleteCharity(id);
        return ResponseEntity.ok().build();
    }
}
