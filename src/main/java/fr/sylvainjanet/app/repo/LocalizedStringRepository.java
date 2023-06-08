package fr.sylvainjanet.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sylvainjanet.app.entities.LocalizedString;

/**
 * Repository.
 * 
 * @author Sylvain
 *
 */
public interface LocalizedStringRepository
    extends JpaRepository<LocalizedString, Long> {

}
