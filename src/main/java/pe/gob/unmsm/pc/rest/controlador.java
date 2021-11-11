package pe.gob.unmsm.pc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.unmsm.pc.models.data;
import pe.gob.unmsm.pc.repository.impl.alumnoRepImpl;

@RestController
@RequestMapping("/pc")
public class controlador {
	
	@Autowired
	private alumnoRepImpl al;
	
	@GetMapping("/listar_alumnos")
    public data listaralumno(@RequestParam String codalu){
		data a = new data();
		a.setAlumno(al.extraerdatos(codalu));
		a.setCurso(al.extraercurso(codalu));
		return a;
    }

}
