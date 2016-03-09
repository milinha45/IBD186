package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Empresa;
import br.gov.sp.fatec.model.Estado;

public interface SegurancaService {
	
	public void exemploTransacao();
	
	public void criarEstado(String nome, String sigla);
	
	public void criarEmpresa(String nome, String cnpj, String sigla);
	
	public Empresa queryEmpresaTop1ByNomeContains(String nome);
	
	public Estado queryEstadoTop1ByNomeContains(String nome);
	
	
	
}
