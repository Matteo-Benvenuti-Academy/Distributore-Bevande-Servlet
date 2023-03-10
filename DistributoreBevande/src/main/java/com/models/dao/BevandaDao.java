package com.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.models.Bevanda;
import com.models.db.ConnettoreDB;


public class BevandaDao implements IDao<Bevanda> {

	private static BevandaDao bevDao;
	
	public static BevandaDao getIstanza() {
		if(bevDao == null)
			bevDao = new BevandaDao();
		
		return bevDao;
	}
	
	public BevandaDao() {
		
	}
	
	@Override
	public boolean insert(Bevanda t) throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();
		
		String query = "INSERT INTO Bevande(nome, descrizione, gradoAlcolico) VALUES (?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, t.getNome());
		ps.setString(2, t.getDescrizione());
		ps.setFloat(3, t.getGradoAlcolico());
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		
		Integer idGenerato = rs.getInt(1);
		t.setBevandaID(idGenerato);
		
		if(idGenerato > 0)
			return true;
		
		return false;
	}

	@Override
	public List<Bevanda> findAll() throws SQLException {
		Connection conn = ConnettoreDB.getIstanza().getConnessione();
		List<Bevanda> elenco = new ArrayList<>();	
		
		String query = "SELECT bevandaID, nome, descrizione,gradoAlcolico FROM Bevande";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Bevanda temp = new Bevanda();
			temp.setBevandaID(rs.getInt(1));
			temp.setNome(rs.getString(2));
			temp.setDescrizione(rs.getString(3));
			temp.setGradoAlcolico(rs.getFloat(4));
			
			elenco.add(temp);
		}
		
		return elenco;
	}

	@Override
	public Bevanda findById(Integer id) throws SQLException {
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Bevanda t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
