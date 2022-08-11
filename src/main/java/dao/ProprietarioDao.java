package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import conexao.MyBatisConnectionFactory;
import model.Proprietario;

public class ProprietarioDao {

	private SqlSessionFactory sqlSessionFactory;
	
	
	public ProprietarioDao() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	//-------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<Proprietario> selectAll(){
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			List<Proprietario> list = session.selectList("Proprietario.getAll");
			return list;
		} finally {
			session.close();
		}
	}

	//-------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------	
	
	public Proprietario selectById(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			Proprietario proprietario = (Proprietario) session.selectOne("Proprietario.getById", id);
			return proprietario;
		} finally {
			session.close();
		}
	}
	
	//-------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------
	
	public void update(Proprietario proprietario) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.update("Proprietario.update", proprietario);
			session.commit();
		} finally {
			session.close();
		}
	}
	//-------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------
	
	public void insert(Proprietario proprietario) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.insert("Proprietario.insert", proprietario);
			session.commit();
		} finally {
			session.close();
		}
	}
	//-------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------
	
	public void delete(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		
		try {
			session.delete("Proprietario.deleteById", id);
			session.commit();
		} finally {
			session.close();
		}
	}
	
}
