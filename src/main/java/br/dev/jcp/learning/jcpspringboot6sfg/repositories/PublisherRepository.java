package br.dev.jcp.learning.jcpspringboot6sfg.repositories;

import br.dev.jcp.learning.jcpspringboot6sfg.domain.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
