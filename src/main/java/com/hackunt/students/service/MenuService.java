package com.hackunt.students.service;

import java.util.List;

import com.hackunt.students.entity.Menu;

public interface MenuService {

	public void updateMenu(Long itemid, Menu menu);

	public Menu getMenuById(Long itemid);

	public List<Menu> getAllMenus();

	public void deleteMenu(Long itemid);

	public void saveMenu(Menu menu);

}
