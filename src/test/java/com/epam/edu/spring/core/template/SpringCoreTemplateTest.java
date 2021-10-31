package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Color;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

/**
*  initial.sequence=42
*  item.repository.implementation=
*/

@ContextConfiguration(classes = MainConfiguration.class)
class SpringCoreTemplateTest {


    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);

    @Test
    @DisplayName("Тест метода Validator.IsItemValid()")
    void testIsItemValid() {
        assertFalse(context.getBean(SimpleItemService.class).createItem(new Item(1, "Pen", 100, Color.YELLOW)));
        assertFalse(context.getBean(SimpleItemService.class).createItem(new Item(9, "Pencil", 6500, Color.GREEN)));
        assertTrue(context.getBean(SimpleItemService.class).createItem(new Item(12, "Notebook", 250, Color.YELLOW)));
    }

    @Test
    @DisplayName("Тест метода SimpleItemService.createItem(Item item)")
    void testCreateItem() {
        assertTrue(context.getBean(SimpleItemService.class).createItem(new Item(9, "Pencil", 320, Color.RED)));
        assertFalse(context.getBean(SimpleItemService.class).createItem(new Item(12, "Notebook", 250, Color.GREEN)));
    }

    @Test
    @DisplayName("Тест метода SimpleItemService.getById(long id)")
    void testGetById() {
        assertTrue(context.getBean(SimpleItemService.class).createItem(new Item(9, "Pencil", 299, Color.RED)));
        assertEquals(true, context.getBean(SimpleItemService.class).getById(42).getName().equals("Pencil"));
        assertNull(context.getBean(SimpleItemService.class).getById(86));
    }
}