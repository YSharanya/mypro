package com.sony.springboot.mydiary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.springboot.mydiary.entity.Entries;
import com.sony.springboot.mydiary.repository.EntriesRepository;

@Service
public class EntriesServiceImpl implements EntriesService {

	@Autowired
	private EntriesRepository entriesRepository;
	
	@Override
	public Entries saveEntries(Entries entries) {
		return entriesRepository.save(entries);
	}

	@Override
	public Entries updateEntries(Entries entries) {
		return entriesRepository.save(entries);
	}

	@Override
	public void deleteEntries(Entries entries) {
		entriesRepository.delete(entries);
	}

	@Override
	public Entries findById(int id) {
		return entriesRepository.findById(id).get();
	}

	@Override
	public List<Entries> findAll() {
		return entriesRepository.findAll();
	}

	@Override
	public List<Entries> findByUserid(int id) {
		return entriesRepository.findByUserid(id);
	}

}
