package com.spring5webapp.demo.Repositories;

import com.spring5webapp.demo.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
