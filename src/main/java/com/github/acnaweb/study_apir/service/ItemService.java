package com.github.acnaweb.study_apir.service;

import com.github.acnaweb.study_apir.dto.ItemRequestUpdate;
import com.github.acnaweb.study_apir.model.Item;
import com.github.acnaweb.study_apir.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductService productService;

    public Item create(){
        return null;
    }

    public Optional<Item> update(Long id, ItemRequestUpdate dto){
        return null;
    }

    public Optional<Item> getItemById(Long id){
        return itemRepository.findById(id);
    }
    public List<Item> getAll(){
        return itemRepository.findAll();
    }
    public boolean deleteItem(Long id){
        if(itemRepository.existsById(id)){
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
