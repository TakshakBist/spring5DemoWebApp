package com.spring5webapp.demo.Repositories;

import com.spring5webapp.demo.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
