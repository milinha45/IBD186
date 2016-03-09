package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Empresa;
import br.gov.sp.fatec.model.Estado;

public interface EstadoRepository  extends CrudRepository<Estado, Long> {

	public Estado findByNome(String nome);
	
	public Estado findBySigla(String sigla);
	
	public Estado findTop1ByNomeContains(String nome);
	
	public List<Estado> findByIdGreaterThan(Long id);
	
	@Query("select u from Estado u where u.nome like %?1%")
	public List<Estado> buscaEstado(String nome);
}
