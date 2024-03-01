package com.uce.edu.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IEstudianteRepository;
import com.uce.edu.repository.IMateriaRepository;
import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.modelo.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	 @Autowired
	 private IEstudianteRepository estudianteRepository;
	 @Autowired
	 private IMateriaRepository iMateriaRepository;
	
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardarMatri(String cedulaEstu, String cod1,String cod2,String cod3,String cod4) {
		 
		Thread hilo=Thread.currentThread();
		String nombreHilos=hilo.getName();
		Estudiante estudiante=this.estudianteRepository.buscarPorCedula(cedulaEstu);
		
		Materia m1=this.iMateriaRepository.buscarPorCodigo(cod1);
		Materia m2=this.iMateriaRepository.buscarPorCodigo(cod2);
		Materia m3=this.iMateriaRepository.buscarPorCodigo(cod3);
		Materia m4=this.iMateriaRepository.buscarPorCodigo(cod4);
		
		List<Materia>listaMaterias=new ArrayList<>();
		listaMaterias.add(m1);
		listaMaterias.add(m2);
		listaMaterias.add(m3);
		listaMaterias.add(m4);
		
		//String hilo=Thread.currentThread().getName();
		for(Materia m:listaMaterias) {
			Matricula matricula=  new Matricula();
			matricula.setEstudiante(estudiante);
			matricula.setFechaMatricula(LocalDate.now());
			matricula.setMateria(m);
			matricula.setNombreHilo(nombreHilos);
			this.iMatriculaRepository.insertar(matricula);
		}
		
	
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<MatriculaDTO> reporte() {
		return this.iMatriculaRepository.reporte();
	}

}
