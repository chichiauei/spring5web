package guru.springframework.spring5web.repositories;

import guru.springframework.spring5web.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
