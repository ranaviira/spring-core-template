package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

import java.util.LinkedList;
import java.util.Random;

public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    public LinkedListItemRepository() {
        super();
        setHolder();
    }

    @Override
    public Item getById(long id) {
        for (Item item : holder) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        initialSequence = new Random().nextInt(99) + 1;
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

    void setInitialSequence(int val) {
        this.initialSequence = val;
    }

    void setHolder() {
        this.holder = new LinkedList<>();
    }
}
