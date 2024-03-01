package com.uce.edu.repository.modelo.dto;

import java.time.LocalDate;

public class MatriculaDTO {
	
	private String cedulaEstudiante;

	private String nombreMateria;

	private String cedulaProf;

	private String nombreHilo;

	public MatriculaDTO() {
		super();
	}

	
	public MatriculaDTO(String cedulaEstudiante, String nombreMateria, String cedulaProf, String nombreHilo) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.nombreMateria = nombreMateria;
		this.cedulaProf = cedulaProf;
		this.nombreHilo = nombreHilo;
	}


	public String getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	public void setCedulaEstudiante(String cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

	

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public String getCedulaProf() {
		return cedulaProf;
	}

	public void setCedulaProf(String cedulaProf) {
		this.cedulaProf = cedulaProf;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}


	@Override
	public String toString() {
		return "MatriculaDTO [cedulaEstudiante=" + cedulaEstudiante + ", nombreMateria=" + nombreMateria
				+ ", cedulaProf=" + cedulaProf + ", nombreHilo=" + nombreHilo + "]";
	}
	
	

}
