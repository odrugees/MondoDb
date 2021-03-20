package co.edu.poli.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.poli.mongodb.model.Capital;
import co.edu.poli.mongodb.model.Country;
import co.edu.poli.mongodb.repository.CountryRepository;


@RestController // Defines that this class is a spring bean
@RequestMapping("/api/v1/")
public class CountriesController {
	
	@Autowired
	CountryRepository countryRepository;
	
	@GetMapping("/Countries")
	public List<Country> getAllCustomers(){
		return countryRepository.findAll();
	}
	
	@PostMapping("/Countries")
	public Country saveCountry(@RequestBody Country country){
		return countryRepository.save(country);
	}
	
	@PostMapping("/CountriesList")
	public List<Country> saveListCountries(@RequestBody List<Country> country) {
		return countryRepository.saveAll(country);
	}
	
	@PutMapping("/Countries/{id}")
	public Country updateCountry(@PathVariable String id, @RequestBody Country country) {
		
		Country _country = countryRepository.findById(id).get();
		
		_country.setName(country.getName());
		_country.setCountry_code(country.getCountry_code());
		_country.setCapital(country.getCapital());
		_country.setTimezones(country.getTimezones());
		_country.setLatlng(country.getLatlng());
		
		countryRepository.save(_country);
		
		return _country;
	}
	
	@DeleteMapping("/Countries/{id}")
	public Country deleteCountriesById(@PathVariable String id) {
		Country _country = countryRepository.findById(id).get();
		countryRepository.deleteById(id);
		return _country;
	}
	
	@DeleteMapping("/CountriesList")
	public void deleteAll() {
		countryRepository.deleteAll();
	}
	
	//Query
	@GetMapping("/CountriesQ1/{name}/{capital}")
	public List<Country> findCustomers1(@PathVariable String name,@PathVariable String capital){
		return countryRepository.findCountriesQ1(name,capital);
	}
	@GetMapping("/CountriesQ2")
	public List<Country> findCustomers2(){
		return countryRepository.findCountriesQ2();
	}
	@GetMapping("/CountriesQ3/{continente}")
	public List<Capital> findCustomers3(@PathVariable String continente){
		return countryRepository.findCountriesQ3(continente);
	}
}
