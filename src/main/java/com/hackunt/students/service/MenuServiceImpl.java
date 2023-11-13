package com.hackunt.students.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackunt.students.entity.Menu;
import com.hackunt.students.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuRepository menuRepository;

	public void saveMenu(Menu menu) {
		menuRepository.save(menu);
	}

	public void updateMenu(Long itemid, Menu menu) {
		Optional<Menu> existingMenuOptional = menuRepository.findById(itemid);

		if (existingMenuOptional.isPresent()) {
			Menu existingMenu = existingMenuOptional.get();
			// Update the properties of the existing menu item with the new values
			existingMenu.setPrice(menu.getPrice());
			existingMenu.setAvailability(menu.getAvailability());
			menuRepository.save(existingMenu);
		} else {
			throw new EntityNotFoundException("Menu item with ID " + itemid + " not found");
		}
	}

	public void deleteMenu(Long itemid) {
		menuRepository.deleteById(itemid);
	}

	public Menu getMenuById(Long itemid) {
		return menuRepository.findById(itemid).orElse(null);
	}

	public List<Menu> getAllMenus() {
		return menuRepository.findAll();
	}

}
