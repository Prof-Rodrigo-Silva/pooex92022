package classe.modelo;

import java.util.Objects;

public class Pessoa {
	
	protected String nome;
	protected int idade;
	protected long numCPF;
	
	public Pessoa () {
		
	}
	
	public Pessoa(String nome, int idade, long numCPF) {
		this.nome = nome;
		this.idade = idade;
		this.numCPF = numCPF;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public long getNumCPF() {
		return numCPF;
	}

	public void setNumCPF(long numCPF) {
		this.numCPF = numCPF;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numCPF);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return numCPF == other.numCPF;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", numCPF=" + numCPF + "]";
	}
	
	public boolean pessoaMaiorIdade(int idade) {
		if(idade >= 18) {
			return true;
		}
		else {
			return false;
		}
	}

}
