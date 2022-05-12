package com.Sync.demo.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.Sync.demo.Repository.SyncRepository;
import com.Sync.demo.model.SyncEntity;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

@Service
@EnableScheduling
public class SyncService {

	@Autowired
	private SyncRepository syncRepository;


	String line = "";
	String filepath = "src/main/resources/AssignmentSheet.csv";

	public void addDataInCsvFile() {
		try {
			//Instantiating the CSVWriter Class
			CSVWriter writer = new CSVWriter(new FileWriter(filepath, true));

			String [] data1 = "2022-05-21 04:25:29,ECOM_222,Brand_New_Clothes,India,Mobile,iOS,3447.000,1559.9999,12194.2255,15875.3333".split(",");
			String[] data2 = {"2022-05-10 04:25:29","ECOM_333","New_Clothes","India","Mobile","iOS","3447.000","1559.9999","12194.2255","15875.3333"};
			String[] data3 = {"2022-05-11 04:25:29","ECOM_444","Brand_Clothes","India","Mobile","iOS","3447.000","1559.9999","12194.2255","15875.3333"};
			//write data into CSV File
			writer.writeNext(data1, false);
			writer.writeNext(data2, false);
			writer.writeNext(data3, false);

			writer.close();	//close the writer
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void deleteDataFromCSVById(int id) {
		try {
			//Instantiating the CSVReader Class
			CSVReader csvReader = new CSVReader(new FileReader(filepath));
			//Creating List type of String Array and read all data from Csv File.
			List<String[]> allDataList = csvReader.readAll();
			//Removing data By Id. id is given by user by postman
			allDataList.remove(id);
			//Instantiating the FileWriter Class With our filepath
			FileWriter fileWriter = new FileWriter(filepath);
			CSVWriter csvWriter = new CSVWriter(fileWriter);
			//using writeAll method to add updated data into csv file
			csvWriter.writeAll(allDataList);
			//close CSVWriter
			csvWriter.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Scheduled(cron = "0 0/2 * * * ?")//Cron job Scheduler to run this method after Every two Minutes
	public void addAllCSVDataIntoDatabase() {
		//Instantiating the BufferedReader Class and Give our filepath address
		try (BufferedReader bufferedReader = new BufferedReader(
				new FileReader(filepath));
				//Instantiating the CSVParser Class
				CSVParser csvParser = new CSVParser(bufferedReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			//Created SyncEntity Type List
			List<SyncEntity> listEntity = new ArrayList<SyncEntity>();
			//Create Iterable and Collecting All Records From CSVParser
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			//For Each Loop to Copy Data
			for (CSVRecord csvRecord : csvRecords) {
				//Instantiating SyncEntity class with Constructor and Adding Them.
				SyncEntity syn = new SyncEntity(csvRecord.get(0), csvRecord.get(1), csvRecord.get(2), csvRecord.get(3),
						csvRecord.get(4), csvRecord.get(5), csvRecord.get(6), csvRecord.get(7), csvRecord.get(8),
						csvRecord.get(9));
				//Adding Data into List
				listEntity.add(syn);
			}
			//clean All Data from Database so that when we add or remove data only updated data come and not added into previous datalist
			syncRepository.deleteAll();
			//save all data into database.
			syncRepository.saveAll(listEntity);
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}

	}
}
