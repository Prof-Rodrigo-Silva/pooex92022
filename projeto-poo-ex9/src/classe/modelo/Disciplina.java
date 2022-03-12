package classe.modelo;

import java.util.Arrays;
import java.util.Objects;

public class Disciplina {
	
	private String nomeDisciplina;
	private double[] notas = new double[4];
	
	public Disciplina() {
		
	}
	
	public Disciplina(String nomeDisciplina, double[] notas) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = notas;
		
	}
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public double[] getNotas() {
		return notas;
	}
	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nomeDisciplina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(nomeDisciplina, other.nomeDisciplina);
	}

	@Override
	public String toString() {
		return "Disciplina [nomeDisciplina=" + nomeDisciplina + ", notas=" + Arrays.toString(notas) + "]";
	}
	
	public double getMediaNotas() {
		double somaNotas = 0;
		for (int i = 0; i < notas.length;i++) {
			somaNotas += notas[i];
		}
		return somaNotas / notas.length;
				
	}
	

}
