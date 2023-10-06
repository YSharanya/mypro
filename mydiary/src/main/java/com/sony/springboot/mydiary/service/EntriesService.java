package com.sony.springboot.mydiary.service;

import java.util.List;

import com.sony.springboot.mydiary.entity.Entries;

public interface EntriesService {

	public Entries saveEntries(Entries entries);
	public Entries updateEntries(Entries entries);
	public void deleteEntries(Entries entries);
	public Entries findById(int id);
	public List<Entries> findAll();
	public List<Entries> findByUserid(int id);
}
