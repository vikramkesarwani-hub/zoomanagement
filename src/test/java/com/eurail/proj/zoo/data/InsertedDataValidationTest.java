/**
 * Licensed Materials - Property of VK
 * 
 * (C) Copyright VK Corp. 2020. All Rights Reserved.
 * 
 */
package com.eurail.proj.zoo.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eurail.proj.zoo.entiry.Animal;
import com.eurail.proj.zoo.entiry.Room;
import com.eurail.proj.zoo.repository.AnimalRepository;
import com.eurail.proj.zoo.repository.RoomRepository;

/**
 * 
 * 
 * @author DiviHome
 * 
 * 
 * 4 Nov 2020
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class InsertedDataValidationTest {

    @Autowired
    private AnimalRepository arepository;
    
    
    @Autowired
    private RoomRepository rrepository;
    
    @Test
    public void should_find_initial_data_entry() {
      Iterable<Animal> animals = arepository.findAll();
      Iterable<Room> rooms = rrepository.findAll();
      assertThat(animals).hasSizeBetween(1, 16);
      assertThat(rooms).hasSizeBetween(1, 10);
    }
}
