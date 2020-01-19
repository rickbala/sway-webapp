package com.rickbala.sway.model.repository;

import com.rickbala.sway.model.Sway;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SwayRepository extends JpaRepository<Sway, Long> {

    List<Sway> findTop30ByChannelOrderByIdDesc(String channel);

}