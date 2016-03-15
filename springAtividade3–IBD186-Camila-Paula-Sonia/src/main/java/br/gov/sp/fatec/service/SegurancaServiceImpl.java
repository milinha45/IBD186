package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Empresa;
import br.gov.sp.fatec.model.Estado;
import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.EmpresaRepository;
import br.gov.sp.fatec.repository.EstadoRepository;
import br.gov.sp.fatec.repository.UsuarioRepository;

@Service("segurancaService")
public class SegurancaServiceImpl implements SegurancaService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	@Autowired
	private EstadoRepository estadoRepo;
	@Autowired
	private EmpresaRepository empresaRepo;

	@Override
	@Transactional
	public void exemploTransacao() {
		// Cria usuario
		Usuario usuario1 = new Usuario();
		usuario1.setNome("Pedro");
		usuario1.setSenha("senha");
	//	usuario1.setEmpresa(empresaRepo.findByNome("X"));
		usuarioRepo.save(usuario1);
		// Gera erro, pois nome e senha sao obrigatorios
		Usuario usuario2 = new Usuario();
		usuarioRepo.save(usuario2);		
	}

	/**
	 * @param usuarioRepo the usuarioRepo to set
	 */
	public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}
	
	@Override
	@Transactional
	public void criarEstado(String nome, String sigla) {
		// Cria estado
		Estado estado1 = new Estado();
		estado1.setNome(nome);
		estado1.setSigla(sigla);
		estadoRepo.save(estado1);	
	}
	
	@Override
	@Transactional
	public void deletarEstado(Estado estado) {
		// Deleta estado
		estadoRepo.delete(estado);
	}
	
	/**
	 * @param estadoRepo the estadoRepo to set
	 */
	public void setEstadoRepo(EstadoRepository estadoRepo) {
		this.estadoRepo = estadoRepo;
	}
	
	@Override
	@Transactional
	public void criarEmpresa(String nome, String cnpj, String sigla) {
		// Cria empresa
		Empresa empresa1 = new Empresa();
		empresa1.setNome(nome);
		empresa1.setCnpj(cnpj);
		empresa1.setEstado(estadoRepo.findBySigla(sigla));
		empresaRepo.save(empresa1);	
	}
	
	@Override
	@Transactional
	public void deletarEmpresa(Empresa empresa) {
		// Deleta empresa
		empresaRepo.delete(empresa);
	}

	/**
	 * @param empresaRepo the empresaRepo to set
	 */
	public void setEmpresaRepo(EmpresaRepository empresaRepo) {
		this.empresaRepo = empresaRepo;
	}
	
	@Override
	@Transactional
	public Empresa queryEmpresaTop1ByNomeContains(String nome){
		return empresaRepo.findTop1ByNomeContains(nome);
	}
	
	
	@Override
	@Transactional
	public Estado queryEstadoTop1ByNomeContains(String nome){
		return estadoRepo.findTop1ByNomeContains(nome);
	}

}
