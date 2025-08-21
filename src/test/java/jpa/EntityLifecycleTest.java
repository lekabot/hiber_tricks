package jpa;

import hiber_tricks.com.jpa.Item;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.Assert.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EntityLifecycleTest {

  @Autowired
  private EntityManager em;

  @Test
  @Transactional
  void testPersist() {
    Item item = new Item();
    item.setName("Test Item");

    assertFalse(em.contains(item));
    em.persist(item);
    assertTrue(em.contains(item));
    assertNotNull(item.getId());
  }
}