package com.boullosa.caminosantiago;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ExpController {
	@Autowired
	ExperienciaRepository experienciaRepository;
	
	@PostMapping("/experiencia")
	public Boolean enviarExp(@RequestBody ExperienciaDto experiencia) {
		ExperienciaEntity experienciaBD = new ExperienciaEntity(experiencia.getNombre(), experiencia.getExperiencia());
		
		experienciaRepository.save(experienciaBD);
		
		return true;
	}
	
	@GetMapping("/obtenerExperiencias")
	public List<ExperienciaDto> obtenerExperiencias(){
		List<ExperienciaDto> listaExperiencias = new ArrayList<ExperienciaDto>();
		
		List<ExperienciaEntity> listaExperienciasBD = experienciaRepository.findAll();
		
		for (ExperienciaEntity experiencia : listaExperienciasBD) {
			listaExperiencias.add(convertirExperienciaEntityAExperienciaDto(experiencia));
		}
		
		return listaExperiencias;
	}
	
	public ExperienciaDto convertirExperienciaEntityAExperienciaDto(ExperienciaEntity experienciaEntity) {
		ExperienciaDto experienciaDto = new ExperienciaDto(experienciaEntity.getAutor(), experienciaEntity.getTexto());
		
		return experienciaDto;
	}
	
	public void mostrarExperiencias() {
		while (true) {
			//Cambiar esto por una llamada al servidor http://localhost:8080/obtenerExperiencias
			List<ExperienciaDto> experiencias = obtenerExperiencias();
			for (ExperienciaDto experiencia : experiencias) {
				//mostrar datos experiencia en pantalla
			}
		}
	}
	
	@RequestMapping(
            value = "/**",
            method = RequestMethod.OPTIONS
    )
    public ResponseEntity handle() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
