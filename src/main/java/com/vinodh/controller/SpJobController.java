package com.vinodh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vinodh.dto.JobDTO;
import com.vinodh.dto.TaskDTO;
import com.vinodh.entity.SpJob;
import com.vinodh.repository.SpJobRepository;
import com.vinodh.repository.SpTaskRepository;
import com.vinodh.service.GenericService;

@RestController
public class SpJobController {

	@Autowired
	private SpJobRepository spJobRepository;

	@Autowired
	private SpTaskRepository spTaskRepository;

	@GetMapping(path = "/spjob" , consumes = "application/json", produces = "application/json")
	public List<JobDTO> findAll() {
		return GenericService.getResponseForJob(spJobRepository.findAll());
	}
	@GetMapping(path = "/sptask")
	public List<TaskDTO> findAllSpTask() {
		return GenericService.getResponseForSpTask(spTaskRepository.findAll());
	}

	@PostMapping("/spjob")
	public SpJob newBook(@RequestBody SpJob alarm) {
		return spJobRepository.save(alarm);
	}

	@GetMapping(path = "/spjob/{id}")
	public JobDTO findOne(@PathVariable Long id) {
		return GenericService.getDTOFromSpJob(spJobRepository.findById(id).get());
	}
	@GetMapping(path = "/sptask/{id}")
	public TaskDTO findOneBySpTask(@PathVariable Long id) {
		return GenericService.getDTOFromSpTask(spTaskRepository.findById(id).get());
	}

	@PutMapping("/spjob/{id}")
	public SpJob saveOrUpdate(@RequestBody SpJob newBook, @PathVariable Long id) {
		return spJobRepository.save(newBook);
	}

	@DeleteMapping("/spjob/{id}")
	public void deleteBook(@PathVariable Long id) {
		spJobRepository.deleteById(id);
	}
	

}
