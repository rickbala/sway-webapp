package com.rickbala.sway.model.repository;

import com.rickbala.sway.model.Sway;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SwayRepository extends MongoRepository<Sway, String> {

    List<Sway> findTop1000ByChannelOrderByDateDesc(String channel);

}
