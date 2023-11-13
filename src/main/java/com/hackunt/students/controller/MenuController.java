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

import com.hackunt.students.entity.Menu;
import com.hackunt.students.service.MenuService;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/menu/v1")
public class MenuController {

    @Autowired
    MenuService menuService;

    // Create a new menu item
    @PostMapping("/addmenu")
    public void saveMenu(@RequestBody Menu menu) {
        menuService.saveMenu(menu);
    }

    // Update an existing menu item
    @PutMapping("/updatemenu/{itemid}")
    public void updateMenu(@PathVariable Long itemid, @RequestBody Menu menu) {
        menuService.updateMenu(itemid, menu);
    }

    // Delete a menu item
    @DeleteMapping("/deletemenu/{itemid}")
    public void deleteMenu(@PathVariable Long itemid) {
        menuService.deleteMenu(itemid);
    }

    // Get details of a specific menu item
    @GetMapping("/getmenu/{itemid}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long itemid) {
        Menu menu = menuService.getMenuById(itemid);
        return ResponseEntity.ok(menu);
    }

    // Get a list of all menu items
    @GetMapping("/getallmenus")
    public ResponseEntity<List<Menu>> getAllMenus() {
        List<Menu> menus = menuService.getAllMenus();
        return ResponseEntity.ok(menus);
    }
}
