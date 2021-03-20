package co.edu.poli.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import co.edu.poli.mongodb.model.Capital;
import co.edu.poli.mongodb.model.Country;

public interface CountryRepository extends MongoRepository<Country, String> {

	@Query("{ 'name' : /.*?0.*/ ,'capital' : /^?1/ }")
	List<Country> findCountriesQ1(String name,String capital);
	
	@Query("{latlng:{$in:[20,40,60]}}")
	List<Country> findCountriesQ2();
	
	@Query("{'timezones':/^?0/},{_id:0,capital:1}")
	List<Capital> findCountriesQ3(String continente);
}
