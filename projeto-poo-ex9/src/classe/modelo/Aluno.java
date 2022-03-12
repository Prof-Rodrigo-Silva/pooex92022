package classe.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import classe.auxiliar.StatusAluno;

public class Aluno extends Pessoa{
	
	private String dataMatricula;
	private String nomeEscola;
	private String serieMatriculado;
	private List<Disciplina> disciplinas;
	
	public Aluno(){
		
	}
	
	public Aluno(String nome,int idade,long numCPF,String dataMatricula,String nomeEscola,String serieMatriculado) {
		super(nome,idade, numCPF);
		this.dataMatricula = dataMatricula;
		this.nomeEscola = nomeEscola;
		this.serieMatriculado = serieMatriculado;
		disciplinas = new ArrayList<Disciplina>();
		
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String getSerieMatriculado() {
		return serieMatriculado;
	}

	public void setSerieMatriculado(String serieMatriculado) {
		this.serieMatriculado = serieMatriculado;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dataMatricula, disciplinas, nomeEscola, serieMatriculado);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(dataMatricula, other.dataMatricula) && Objects.equals(disciplinas, other.disciplinas)
				&& Objects.equals(nomeEscola, other.nomeEscola)
				&& Objects.equals(serieMatriculado, other.serieMatriculado);
	}

	@Override
	public String toString() {
		return "Aluno [dataMatricula=" + dataMatricula + ", nomeEscola=" + nomeEscola + ", serieMatriculado="
				+ serieMatriculado + ", disciplinas=" + disciplinas + "]";
	}
	
	public double calculaMediaGeral() {
		double somaNotas = 0;
		for (Disciplina disciplina : disciplinas) {
			somaNotas += disciplina.getMediaNotas();
		}
		return somaNotas / disciplinas.size();
	}
	
	public boolean calculaMediaGeral1() {
		double media = this.calculaMediaGeral();
		if(media >= 7) {
			return true;
		}else {
			return false;
			}	
	}
	
	public String calaculaMediaGeral2() {
		double media = this.calculaMediaGeral();
		if(media >= 5) {
			if(media >= 7) {
				return StatusAluno.APROVADO;
			}
			return StatusAluno.RECUPERACAO;
		}else {
			return StatusAluno.REPROVADO;
		}
	}

}
