package application.service;

import application.model.Menu;

public interface MenuService {
    Menu findById(Long id);
    Menu create(Menu menuToCreate);
}
