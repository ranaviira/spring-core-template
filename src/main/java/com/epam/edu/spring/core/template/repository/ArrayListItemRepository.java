package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    public ArrayListItemRepository() {
        super();
        setHolder();
    }

    @Override
    public Item getById(long id) {
        for (Item element : holder) {
            if (element.getId() == id) {
                return element;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        item.setId(initialSequence);
        if (!(holder.isEmpty())) {
            for (Item element : holder) {
                if (element.getId() == item.getId()) {
                    return false;
                }
            }
        }
        holder.add(item);
        return true;
    }

    @Value("${initial.sequence}")
    void setInitialSequence(int val) {
        this.initialSequence = val;
    }

    void setHolder() {
        this.holder = new ArrayList<>();
    }
}
