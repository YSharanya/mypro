package com.sony.springboot.mydiary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sony.springboot.mydiary.entity.Entries;

public interface EntriesRepository extends JpaRepository<Entries, Integer> {
	
	@Query(value="select * from entries where userid=:id",nativeQuery=true)
	public List<Entries> findByUserid(int id);

}
