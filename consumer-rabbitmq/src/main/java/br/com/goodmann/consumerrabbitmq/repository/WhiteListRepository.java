package br.com.goodmann.consumerrabbitmq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.goodmann.consumerrabbitmq.model.WhiteList;

@Repository
public interface WhiteListRepository extends JpaRepository<WhiteList, Integer> {

	public List<WhiteList> findAllByClientIsNull();

	public List<WhiteList> findAllByClient(String client);

}
