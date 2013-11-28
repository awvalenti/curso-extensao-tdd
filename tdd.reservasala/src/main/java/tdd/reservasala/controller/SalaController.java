package tdd.reservasala.controller;

import tdd.reservasala.dao.SalaDao;
import tdd.reservasala.domain.Sala;
import tdd.reservasala.service.ReservaService;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class SalaController {

	private final SalaDao salaDao;
	private final ReservaService reservaService;
	private final Result result;
	
	public SalaController(SalaDao salaDao, ReservaService reservaService, Result result) {
		this.salaDao = salaDao;
		this.reservaService = reservaService;
		this.result = result;
	}
	
	public void nova() {
	}
	
	@Post
	public void incluir(Sala sala) {
		salaDao.incluir(sala);
		result.redirectTo(this).listar();
	}

	public void listar() {
		result.include("salas", salaDao.buscarTodas());
		result.include("reservas", reservaService.buscarReservasPorIdSala(0));
	}
	
}
