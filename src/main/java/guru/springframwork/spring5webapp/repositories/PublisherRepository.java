package guru.springframwork.spring5webapp.repositories;

import guru.springframwork.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
