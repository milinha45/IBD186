package br.sp.gov.fatec;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Empresa;
import br.gov.sp.fatec.model.Estado;
import br.gov.sp.fatec.repository.EmpresaRepository;
import br.gov.sp.fatec.repository.EstadoRepository;
import br.gov.sp.fatec.service.SegurancaService;

/**
 * @author Camila, Paula e Sonia
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/EmpresaRepositoryTest-context.xml" })
@Rollback
@Transactional
public class EmpresaRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	SegurancaService seg = (SegurancaService)context.getBean("segurancaService");


	
	private static final String NOME = "Y";
	private static final String CNPJ = "123456789/0101";
	private static final String SIGLA = "SP";
	private static final String NOME_ESTADO = "São Paulo";
	
	
	@Autowired
	private EmpresaRepository empresaRepo;
	@Autowired
	private EstadoRepository estadoRepo;

	
	/**
	 * @param estadoRepo the estadoRepo to set
	 */
	public void setEstadoRepo(EstadoRepository estadoRepo) {
		this.estadoRepo = estadoRepo;
	}
	
	/**
	 * @param empresaRepo the empresaRepo to set
	 */
	public void setEmpresaRepo(EmpresaRepository empresaRepo) {
		this.empresaRepo = empresaRepo;
	}

	@Test
	public void testeInsercaoOk() {
		Empresa empresa = new Empresa();
		Estado estado = new Estado();
		
		estado.setSigla(SIGLA);
		estado.setNome(NOME_ESTADO);
		estadoRepo.save(estado);
		
		empresa.setNome(NOME);
		empresa.setCnpj(CNPJ);
		empresa.setEstado(estadoRepo.findBySigla("SP"));
		empresaRepo.save(empresa);
		assertTrue(empresa.getId() != null);
	}
	
	
	@Test
	public void testeDelecaoOk() {
		Empresa empresa = new Empresa();
		Estado estado = new Estado();
		
		estado.setSigla(SIGLA);
		estado.setNome(NOME_ESTADO);
		estadoRepo.save(estado);
		
		empresa.setNome(NOME);
		empresa.setCnpj(CNPJ);
		empresa.setEstado(estadoRepo.findBySigla("SP"));
		empresaRepo.save(empresa);
		
		empresaRepo.delete(empresa);
		assertTrue(empresaRepo.findByCnpj(empresa.getCnpj()) == null);
	}
	
	@Test
	public void testeAtualizacaoOk() {
		Empresa empresa = new Empresa();
		Estado estado = new Estado();
		
		estado.setSigla(SIGLA);
		estado.setNome(NOME_ESTADO);
		estadoRepo.save(estado);
		
		
		empresa.setNome(NOME);
		empresa.setCnpj(CNPJ);
		empresa.setEstado(estadoRepo.findBySigla("SP"));
		empresaRepo.save(empresa);
		
		empresa.setNome("Z");
		empresaRepo.save(empresa);
		
		
		assertEquals (empresaRepo.findByNome("Z").getCnpj(), empresa.getCnpj());
	}
	
	@Test
	public void testeSelecaoOk() {
		
		seg.criarEstado(NOME_ESTADO, SIGLA);
		seg.criarEmpresa(NOME, CNPJ, SIGLA);
		
		Empresa empresa = seg.queryEmpresaTop1ByNomeContains(NOME);
		
		assertEquals (empresa.getNome(), NOME);
		assertEquals (empresa.getCnpj(), CNPJ);
		assertEquals (empresa.getEstado().getSigla(), SIGLA);
		
		seg.deletarEmpresa(seg.queryEmpresaTop1ByNomeContains(NOME));
		seg.deletarEstado(seg.queryEstadoTop1ByNomeContains(NOME_ESTADO));
	}
}
