package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Matricula matricula) {
	this.entityManager.persist(matricula);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<MatriculaDTO> reporte() {
		TypedQuery<MatriculaDTO> query = this.entityManager.createQuery(
				"Select New com.uce.edu.repository.modelo.dto.MatriculaDTO(e.cedula,ma.nombre,ma.cedulaProf,m.nombreHilo)"
				+ "   From Matricula m "
				+ "  JOIN m.estudiante e "
				+ "  JOIN m.materia ma",
				MatriculaDTO.class);
		return query.getResultList();
	}

}
