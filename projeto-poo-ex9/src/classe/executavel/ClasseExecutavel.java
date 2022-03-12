package classe.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import classe.auxiliar.StatusAluno;
import classe.modelo.Aluno;
import classe.modelo.Disciplina;

public class ClasseExecutavel {
	
	public static void main(String[] args) {
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		int nroAluno = Integer.parseInt(JOptionPane.showInputDialog("Qual o nro de alunos?"));
		int nroDisciplinas = Integer.parseInt(JOptionPane.showInputDialog("Qual o nro de disciplinas por aluno?"));
		
		
		for(int i = 0; i < nroAluno; i++) {
			String nome = JOptionPane.showInputDialog("Qual o nome do aluno? ");
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Qual idade? "));
			long cpf = Long.parseLong(JOptionPane.showInputDialog("Qual o CPF? "));
			String dataMatricula = JOptionPane.showInputDialog("Qual a data de matrícula? ");
			String nomeEscola = JOptionPane.showInputDialog("Qual o nome da escola? ");
			String serieMatriculado = JOptionPane.showInputDialog("Qual a série? ");
			
			Aluno aluno = new Aluno(nome, idade, cpf, dataMatricula, nomeEscola, serieMatriculado);
			
			for(int j = 0; j < nroDisciplinas; j++) {
				String nomeDisciplina = JOptionPane.showInputDialog("Nome da "+(j+1)+"º Disciplina?");
				double[] notas = new double[4];
				for(int w = 0; w <= 3; w++) {
					double nota = Double.parseDouble(JOptionPane.showInputDialog((w+1)+"º Nota da Disciplina?"));
					notas[w] = nota;						
				}
				Disciplina disciplina = new Disciplina(nomeDisciplina, notas);
					
				aluno.getDisciplinas().add(disciplina);
			}
			alunos.add(aluno);
		}
		
		List<Aluno> alunosAprovados = new ArrayList<Aluno>();
		List<Aluno> alunosRecuperacao = new ArrayList<Aluno>();
		List<Aluno> alunosReprovados = new ArrayList<Aluno>();
		
		HashMap<String, List<Aluno>> mapAlunos = new HashMap<String, List<Aluno>>();
		
		mapAlunos.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		mapAlunos.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
		mapAlunos.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
		
		for(Aluno aluno : alunos) {
			
			if(aluno.calaculaMediaGeral2().equalsIgnoreCase(StatusAluno.APROVADO)) {
				mapAlunos.get(StatusAluno.APROVADO).add(aluno);
			}else if(aluno.calaculaMediaGeral2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				mapAlunos.get(StatusAluno.RECUPERACAO).add(aluno);
			}else {
				mapAlunos.get(StatusAluno.REPROVADO).add(aluno);
			}
		}
		
		System.out.println("------------------Lista Aprovados----------------");
		for(Aluno aluno: mapAlunos.get(StatusAluno.APROVADO)){
					System.out.println("Aluno: "+aluno.getNome());
					System.out.println("Média do Aluno: "+aluno.calculaMediaGeral());
					System.out.println("Resultado: "+aluno.calaculaMediaGeral2());
					System.out.println("-------------------------------------------------------");
			
		}
		System.out.println("------------------Lista Recuperacao----------------");
		for(Aluno aluno: mapAlunos.get(StatusAluno.RECUPERACAO)){
					System.out.println("Aluno: "+aluno.getNome());
					System.out.println("Média do Aluno: "+aluno.calculaMediaGeral());
					System.out.println("Resultado: "+aluno.calaculaMediaGeral2());
					System.out.println("-------------------------------------------------------");
			
		}
		System.out.println("------------------Lista Reprovados----------------");
		for(Aluno aluno: mapAlunos.get(StatusAluno.REPROVADO)){
					System.out.println("Aluno: "+aluno.getNome());
					System.out.println("Média do Aluno: "+aluno.calculaMediaGeral());
					System.out.println("Resultado: "+aluno.calaculaMediaGeral2());
					System.out.println("-------------------------------------------------------");
		}
		
	}

}
