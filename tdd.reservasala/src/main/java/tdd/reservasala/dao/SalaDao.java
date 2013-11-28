package tdd.reservasala.dao;

import java.util.List;

import tdd.reservasala.domain.Sala;

public interface SalaDao {

	Sala buscarPorId(long id);

	List<Sala> buscarTodas();

}
