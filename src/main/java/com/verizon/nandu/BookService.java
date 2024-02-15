package com.verizon.nandu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

	@Autowired
	RestTemplate restTemplate;

	List<Book> listOfBooks = Arrays.asList(new Book(101, "Sapiens", "self-help", "Evolution of life"),
			new Book(102, "The power of subconcious mind", "self-help", "Building confidence and growing our mindset"),
			new Book(212, "The secret the power", "self-help", "About the universal law of attraction"),
			new Book(104, "Alchemist", "self-help", "Find our own desires"));

	List<Book> getAllBooks() {
		return listOfBooks;
	}

	Book getBookById(@PathVariable Integer id) {
		return new Book(102, "The power of subconcious mind", "self-helf",
				"Building confidence and growing our mindset");
	}

	List<Object> getAllUsers() {

		String urlOfOtherService = "http://localhost:8081/api/v1/users";

		Object[] returnedData = restTemplate.getForObject(urlOfOtherService, Object[].class);

		return Arrays.asList(returnedData);
	}
	
	String addUser( Object book) {
		 restTemplate.postForObject( "http://localhost:8081/api/v1/user", book, Object[].class);
		 return "Added";
	}
	
	String deleteUser(Integer id) {
		restTemplate.delete("http://localhost:8081/api/v1/user" + id);
		return "Deleted";
	}


}
