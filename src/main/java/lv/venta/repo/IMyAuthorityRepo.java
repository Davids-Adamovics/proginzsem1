package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.MYAuthority;

public interface IMyAuthorityRepo extends CrudRepository<MYAuthority, Integer> {

	
}
