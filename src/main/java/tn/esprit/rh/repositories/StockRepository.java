package tn.esprit.rh.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.rh.entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
	

	
	
	
	
	
	
	
	
	
	
	
	@Query("SELECT s FROM Stock s where s.qte< s.qteMin")
	List<Stock> retrieveStatusStock();
}
