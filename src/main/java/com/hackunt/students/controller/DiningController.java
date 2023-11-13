package com.hackunt.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackunt.students.entity.Dining;
import com.hackunt.students.entity.Menu;
import com.hackunt.students.service.DiningService;

@RestController
@RequestMapping(value = "/api/dining/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class DiningController {

    @Autowired
    DiningService diningService;

    // Create a new dining table
    @PostMapping("/addnewdiningtable")
    public void addNewDiningTable(@RequestBody Dining dining) {
//    	Menu menu = dining.getMenu();
//    	dining.setMenu(menu);
        diningService.addNewDiningTable(dining);
    }

    // Update an existing dining table
    @PutMapping("/updatetable/{tableid}")
    public void updateTable(@PathVariable Long tableid, @RequestBody Dining dining) {
        diningService.updateTable(tableid, dining);
    }

    // Delete a dining table
    @DeleteMapping("/deletetable/{tableid}")
    public void deleteTable(@PathVariable Long tableid) {
        diningService.deleteTable(tableid);
    }

    // Get details of a specific dining table
    @GetMapping("/gettable/{tableid}")
    public ResponseEntity<Dining> getTableById(@PathVariable Long tableid) {
        Dining dining = diningService.getTableById(tableid);
        return ResponseEntity.ok(dining);
    }

    // Get a list of all dining tables
    @GetMapping("/getalltables")
    public ResponseEntity<List<Dining>> getAllTables() {
        List<Dining> diningTables = diningService.getAllTables();
        return ResponseEntity.ok(diningTables);
    }
    
    // Get a list of all available dining tables
    @GetMapping("/getallavailabletables")
    public ResponseEntity<List<Long>> getAllAvailableTables() {
    	List<Long> listOfAvailableTables= diningService.getTablesByAvailability("yes");
        return ResponseEntity.ok(listOfAvailableTables);
    }

}
