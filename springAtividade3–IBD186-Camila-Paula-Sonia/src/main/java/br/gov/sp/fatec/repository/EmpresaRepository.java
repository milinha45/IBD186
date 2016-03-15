package br.gov.sp.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.gov.sp.fatec.model.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Long>{

public Empresa findByNome(String nome);
	
	public Empresa findByCnpj(String cnpj);
	
	public Empresa findTop1ByNomeContains(String nome);
	
	public List<Empresa> findByIdGreaterThan(Long id);
	
	@Query("select u from Empresa u where u.nome like %?1%")
	public List<Empresa> buscaEmpresa(String nome);
	
}