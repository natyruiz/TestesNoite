package br.sceweb.teste;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa {
	
	static EmpresaDAO empresaDAO;
	static Empresa empresa; 
	
	Logger logger = Logger.getLogger(UC01CadastrarEmpresa.class);
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("33985142000104");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua das olivas");
		empresa.setTelefone("1155112233");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
			empresaDAO.exclui("33985142000104");
		}
	
	@Test
	public void CT01UC01Cadastra_com_sucesso () {
		logger.info("Iniciando o CT01UC01Cadastra_com_sucesso");
		logger.info("Resultado Exclui CPF 33985142000104: "+empresaDAO.exclui("33985142000104"));
		assertEquals(1,empresaDAO.adiciona(empresa));
		empresaDAO.exclui("33985142000104");
	}

}
