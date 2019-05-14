package com.prjcadcliente.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.prjcadcliente.dominio.Cliente;

/**
 * <b>CRUDCLIENTE</B><br>
 * Essa classe permite manipular as informa��es do cliente. aqui voce encontrara os seguintes comandos:
 * <ul>
 * <li>Cadastro</li>
 * <li>Pesquisar por nome e por id</li>
 * <li>Atualizar</li>
 * <li>Deletar</li>
 * </ul>
 * 
 * @author jonas.ncarvalho
 *
 */
public class CRUDCliente {
	

	private Connection con = null;
	private ResultSet rs = null;
	private PreparedStatement pst = null;
	
	public String cadastrar(Cliente cliente) {
		
		String msg ="";
		
		//Cria��o dos objetos para a conexao com o banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/clientedb","root","");
			
			String consulta = "INSERT INTO tbcliente(nome,email,telefone,idade)values(?,?,?,?)";
			
			// abaixo serve para pegar do metodo cadastrar 
			
			pst = con.prepareStatement(consulta);
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEmail());
			pst.setString(3, cliente.getTelefone());
			pst.setInt(4, cliente.getIdade());
			
			int r = pst.executeUpdate();
			
			
			if(r > 0)
				msg = "Cadastro realizado com sucesso!";
			else
				msg = "Nao foi possivel cadastrar!";
			
			
		}
		catch(SQLException ex) {
			msg = "Erro ao tentar cadastrar:"+ex.getMessage();
		}
		catch(Exception e ) {
			msg = "Erro inesperado"+e.getMessage();
		}
		finally {
			try{con.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		return msg;
		
	}
	 
	public String atualizar(Cliente cliente) {
		return null;
			
			String msg ="";
		
		//Cria��o dos objetos para a conexao com o banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/clientedb","root","");
			
			String consulta = "UPDATE tbcliente SET nome=?,email=?,telefone=?,idade=? WHERE id=?";
			
			// abaixo serve para pegar do metodo cadastrar 
			
			pst = con.prepareStatement(consulta);
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEmail());
			pst.setString(3, cliente.getTelefone());
			pst.setInt(4, cliente.getIdade());
			pst.setInt(5, cliente.getId());
			
			int r = pst.executeUpdate();
			
			
			if(r > 0)
				msg = "Atualiza��o realizada com sucesso!";
			else
				msg = "Nao foi possivel atualizar!";
			
			
		}
		catch(SQLException ex) {
			msg = "Erro ao tentar atualizar:"+ex.getMessage();
		}
		catch(Exception e ) {
			msg = "Erro inesperado"+e.getMessage();
		}
		finally {
			try{con.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		return msg;
	}
	
	public String deletar(Cliente cliente) {
String msg ="";
		
		//Cria��o dos objetos para a conexao com o banco de dados
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/clientedb","root","");
			
			String consulta = "DELETE FROM tbcliente WHERE id=?";
			
			// abaixo serve para pegar do metodo cadastrar 
			
			pst = con.prepareStatement(consulta);
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEmail());
			pst.setString(3, cliente.getTelefone());
			pst.setInt(4, cliente.getIdade());
			pst.setInt(5, cliente.getId());
			
			
			int r = pst.executeUpdate();
			
			
			if(r > 0)
				msg = "Deletado com sucesso!";
			else
				msg = "Nao foi possivel deletar!";
			
			
		}
		catch(SQLException ex) {
			msg = "Erro ao tentar atualizar:"+ex.getMessage();
		}
		catch(Exception e ) {
			msg = "Erro inesperado"+e.getMessage();
		}
		finally {
			try{con.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		return msg;
	}
	
	public List<Cliente> PesquisarPorNome(String nome){
		return null;
	}
	
	public Cliente PesquisarPorId(int id){
		return null;
	}
	
	public Cliente PesquisarTodos() {
		return null;
	}
}
