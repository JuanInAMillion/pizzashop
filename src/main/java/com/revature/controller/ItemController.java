package com.revature.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.ItemNotFoundException;
import com.revature.model.Items;
import com.revature.repo.ItemRepo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/itempage")
public class ItemController {
	
	@Autowired
	private ItemRepo itemRepo;
	
	@PostMapping("/items")
	public Items createItem(@Valid @RequestBody Items item) {
		return itemRepo.save(item);
	}
	
	@GetMapping("/items")
	public List<Items> getAllItems() {
		return itemRepo.findAll();
	}
	
	@GetMapping("/items/{itemId}")
	public ResponseEntity<Items> getItemById(@PathVariable(value = "itemId") int itemId) throws ItemNotFoundException {
		Items item = itemRepo.findById(itemId)
		.orElseThrow(() -> new ItemNotFoundException("Item with id " + itemId + " was not found"));
		
		return ResponseEntity.ok(item);
	}
	
	@PostMapping("/addtocart/{itemId}")
	public ResponseEntity<Items> addItemToCart(@Valid @RequestBody int itemId) throws ItemNotFoundException{
		Items item = itemRepo.findById(itemId)
		.orElseThrow(() -> new ItemNotFoundException("Item with id " + itemId + " was not found"));
		
		return ResponseEntity.ok(item);
	}
	
	@DeleteMapping("items/{itemId}")
	public Map<String, Boolean> deleteItem(@PathVariable(value = "itemId") int itemId) throws ItemNotFoundException {
		Items item = itemRepo.findById(itemId)
		.orElseThrow(() -> new ItemNotFoundException("Item with id " + itemId + " was not found"));
		
		itemRepo.delete(item);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
