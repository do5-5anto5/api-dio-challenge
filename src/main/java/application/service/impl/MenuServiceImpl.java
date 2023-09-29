package application.service.impl;

import application.model.Menu;
import application.repository.MenuRepository;
import application.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu findById(Long id) {
        return menuRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Menu create(Menu menuToCreate) {
        if(menuRepository.existsByCategoryName(String.valueOf(menuToCreate.getCategories()
                .stream()
                .anyMatch(x -> menuRepository.existsByCategoryName(x.getName()))
            ))){
            throw new IllegalArgumentException("There are redundant categories.");
        }
        return menuRepository.save(menuToCreate);
    }

    //ToDo need to implement more handling exceptions, like can not create category without a menu,
    // and no item without a category
}