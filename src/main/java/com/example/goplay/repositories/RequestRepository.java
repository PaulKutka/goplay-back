package com.example.goplay.repositories;

import com.example.goplay.beans.entity.request.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Long> {
}
