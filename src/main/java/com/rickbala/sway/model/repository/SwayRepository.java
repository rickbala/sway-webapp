package com.rickbala.sway.model.repository;

import com.rickbala.sway.model.Sway;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SwayRepository extends MongoRepository<Sway, Long> {

    //TODO see if this kind of header declaration works for a MongoRespotory - now it's using findAll()
    List<Sway> findTop30ByChannelOrderByIdDesc(String channel);

}