package pe.gob.unmsm.pc.repository.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.gob.unmsm.pc.mapper.AlumnoRowMapper;
import pe.gob.unmsm.pc.mapper.CursoRowMapper;
import pe.gob.unmsm.pc.models.Alumno;
import pe.gob.unmsm.pc.models.Curso;
import pe.gob.unmsm.pc.repository.alumnoRepository;
@Repository
public class alumnoRepImpl extends JdbcDaoSupport implements alumnoRepository {

	@Autowired
	private ApplicationContext context;
	
	private static String conn="jdbc_sgv";
	
	@Autowired
        //metodo de conexion
	public void fuenteDatos (DataSource setDataSource) {
		setDataSource(setDataSource);
	}

	@Override
	public Alumno extraerdatos(String codalu) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
        //consulta sql
		String sql="select * from alumno where codalu=?";
		return jdbctemplate.queryForObject(sql, new AlumnoRowMapper(),codalu);
		
	}

	@Override
	public List<Curso> extraercurso(String codalu) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
        //consulta sql
		String sql="select c.codcur,c.nomcur,d.nota \r\n"
				+ "from alumno a \r\n"
				+ "inner join curso_alumno d on a.codalu=d.codalu \r\n"
				+ "inner join curso c on c.codcur=d.codcur\r\n"
				+ "where a.codalu=?";
		return jdbctemplate.query(sql, new CursoRowMapper(),codalu);
	}
	
	
	
}
