package com.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cjc.main.model.Person;

@RestController
public class HomeController {
	
	@Autowired
	RestTemplate rt;

@PostMapping("/insert")
public String insertData(@RequestBody Person p) {
	String url="http://localhost:8085/insertData";

	rt.postForObject(url,p, String.class);
	return "success";
}
@GetMapping("/getAll/{address}/{name}")
public List getAllData(@PathVariable("address")String ad,@PathVariable("name")String nm) {
	
	String url="http://localhost:8086/getAll/"+ad+"/"+nm+"";
	List l=rt.getForObject(url, List.class);
	return l;
}

@GetMapping("/getDataId/{id}")
public List getDataId(@PathVariable("id")int id) {
	
	String url="http://localhost:8086/getDataId/"+id+"";
	List l=rt.getForObject(url, List.class);
	return l;
}

@PutMapping("/update/{id}")
public String update(@PathVariable("id")int id,@RequestBody Person p) {
	
	String url="http://localhost:8087/update/"+id+"";
	rt.put(url,p);
	return "Success";
}

@DeleteMapping("/deleteData/{id}")
public String delete(@PathVariable("id") int id) {
	String url="http://localhost:8088/deleteData/"+id+"";
	rt.delete(url);
	return "Success";
}
}

