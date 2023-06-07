package fr.sylvainjanet.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import fr.sylvainjanet.app.entities.Message;

/**
 * Repository.
 * 
 * @author Sylvain
 *
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
  /**
   * Truncate table.
   */
  @Modifying
  @Transactional
  @Query(value = "TRUNCATE TABLE message", nativeQuery = true)
  void truncateTable();

}
