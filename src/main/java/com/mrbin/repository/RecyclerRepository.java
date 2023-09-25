package com.mrbin.repository;

import com.mrbin.models.Recycler;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclerRepository extends MongoRepository<Recycler, String> {
}
