package com.spring5webapp.demo.Repositories;

import com.spring5webapp.demo.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
