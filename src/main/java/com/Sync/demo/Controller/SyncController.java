package com.Sync.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Sync.demo.Service.SyncService;

@RestController
public class SyncController {

	@Autowired
	private SyncService syncService;//Autowired SyncService Class

	@RequestMapping(path = "/addDataInCsvFile")
	public String addDataInCsvFile() {
		//Calling Service class addDataInCsvFile method
		syncService.addDataInCsvFile();
		return " Data is Added in CSV File";
	}



	@DeleteMapping(path = "/deleteDataFromCSVById/{id}")
	public String deleteDataFromCSVById(@PathVariable (value = "id") int id) {
		//Calling Service Class deleteDataFromCSVById method And Sending ID Which Collect By Postman
		syncService.deleteDataFromCSVById(id);
		return "Data is Deleted from Csv File Successfully";

	}

	@PostMapping(path = "/addAllCSVDataIntoDatabase")
	public String addAllCSVDataIntoDatabase() {
		//Calling Service Class addAllCSVDataIntoDatabase method for adding Latest
		syncService.addAllCSVDataIntoDatabase();
		return "Data is Added Successfully into the DataBase";
	}

}
