package br.com.goodmann.consumerrabbitmq.whitelist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhiteListRepository extends JpaRepository<WhiteList, Integer> {

}
