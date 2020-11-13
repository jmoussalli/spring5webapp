package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Package :  guru.springframework.spring5webapp.repositories
 * Created by jerom on 13/11/2020 at 20:43
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
