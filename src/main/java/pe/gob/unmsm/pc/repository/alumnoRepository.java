package pe.gob.unmsm.pc.repository;

import java.util.List;

import pe.gob.unmsm.pc.models.Alumno;
import pe.gob.unmsm.pc.models.Curso;

public interface alumnoRepository {
	
	public Alumno extraerdatos(String codalu);
	public List<Curso> extraercurso(String codalu);

}
