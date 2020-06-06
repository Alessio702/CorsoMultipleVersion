package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Corso;

public interface CorsoService {
	
	public List<Corso> getAllCorsi();
	
	public Corso getCorsoById(Integer id);
	
	public void saveOrUpdate(Corso odocente);
	
	public void deleteCorso(Integer idCorso);


}
