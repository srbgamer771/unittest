package com.fca.calidad.doubles;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.is;

public class FakeDaoAlumnoTest {
	
	private FakeMySqlDao dao;
	private Alumno alumno;
	
	public HashMap<Integer, Alumno> alumnos_db;

	@Before
	public void setUp() throws Exception {
		dao = Mockito.mock(FakeMySqlDao.class);
		alumnos_db = new HashMap<Integer, Alumno>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createAlumnoTest() {
		alumno = new Alumno(1,"nombre", 15, "Correo");
		
		//Vamos a probar el método createAlumno
		//Tenemos que programar el comportamiento 
		
		
		when(dao.addAlumno(any(Alumno.class))).thenAnswer(new Answer<Boolean>() {
			
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
			 Alumno arg = (Alumno) invocation.getArguments()[0];
			 
			 alumnos_db.put(arg.getId(), arg);
			 return true;
			}
		});
		
		//Ejercitar el código
		int oldSize = alumnos_db.size();
		dao.addAlumno(alumno);
		int newSize = alumnos_db.size();
		
		//Verificamos
		assertThat(newSize, is(oldSize + 1));
	}

}
