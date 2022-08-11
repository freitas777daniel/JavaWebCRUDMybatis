package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import conexao.MyBatisConnectionFactory;
import model.Veiculo;

public class VeiculoDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public VeiculoDao() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	//-------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------
		@SuppressWarnings("unchecked")
		public List<Veiculo> selectAll(){
			SqlSession session = sqlSessionFactory.openSession();
			
			try {
				List<Veiculo> list = session.selectList("VeiculoV.getAll");
				return list;
			} finally {
				session.close();
			}
		}

		//-------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------	
		
		public Veiculo selectById(int id) {
			SqlSession session = sqlSessionFactory.openSession();
			
			try {
				Veiculo veiculo = (Veiculo) session.selectOne("VeiculoV.getById", id);
				return veiculo;
			} finally {
				session.close();
			}
		}
		
		//-------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------
		
		public void update(Veiculo veiculo) {
			SqlSession session = sqlSessionFactory.openSession();
			
			try {
				session.update("VeiculoV.update", veiculo);
				session.commit();
			} finally {
				session.close();
			}
		}
		//-------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------
		//-------------------------------------------------------------------------------
		
		public void insert(Veiculo veiculo) {
			SqlSession session = sqlSessionFactory.openSession();
			
			try {
				session.insert("VeiculoV.insert", veiculo);
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
				session.delete("VeiculoV.deleteById", id);
				session.commit();
			} finally {
				session.close();
			}
		}
	
	
	
}
