package com.fca.calidad.doubles;

public interface IAlumnoDao {

	public boolean addAlumno(Alumno a);
	public boolean deleteAlumno(Alumno a);
	public boolean updateEmail(Alumno a);
	public Alumno consultarAlumno(String id);
}
