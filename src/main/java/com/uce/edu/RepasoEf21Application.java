package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.dto.MatriculaDTO;
import com.uce.edu.service.IMatriculaService;

@SpringBootApplication
public class RepasoEf21Application implements CommandLineRunner{

	
	@Autowired
	private IMatriculaService iMatriculaService;
	
	public static void main(String[] args) {
		SpringApplication.run(RepasoEf21Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<MatriculaDTO>lista=this.iMatriculaService.reporte();
		
		for(MatriculaDTO m:lista) {
			System.out.println(m);
		}
		
	}

}
