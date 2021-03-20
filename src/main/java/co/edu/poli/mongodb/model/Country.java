package co.edu.poli.mongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Countries")
public class Country {
	@Id
	private String countriesId;
	
	private String name;
	
	private String country_code;
	
	private String capital;
	
	private List<Double> latlng;
	
	private List<String> timezones;
	
	public Country() {
		
	}

	public Country(String countriesId, String name, String country_code, String capital, List<Double> latlng,
			List<String> timezones) {
		super();
		this.countriesId = countriesId;
		this.name = name;
		this.country_code = country_code;
		this.capital = capital;
		this.latlng = latlng;
		this.timezones = timezones;
	}

	public String getCountriesId() {
		return countriesId;
	}

	public void setCountriesId(String countriesId) {
		this.countriesId = countriesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public List<Double> getLatlng() {
		return latlng;
	}

	public void setLatlng(List<Double> latlng) {
		this.latlng = latlng;
	}

	public List<String> getTimezones() {
		return timezones;
	}

	public void setTimezones(List<String> timezones) {
		this.timezones = timezones;
	}
	
	
	
}

