package course;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Empregado;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos empregados serao registrados: ");
		int numeroEmpregados = sc.nextInt();
		
		List<Empregado> staff = new ArrayList<>();

		for( int x = 1; x <= numeroEmpregados; x++ ) {
			System.out.println("Informe os dados do empregado #" + x + ":" );
			
			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Nome: ");
			String nome = sc.nextLine();

			
			System.out.print("Salario: ");
			double salario = sc.nextDouble();

			staff.add( new Empregado( id, nome, salario) );
		}
		
		System.out.println(" " );
		System.out.println("Empregados registrados:" );
		
		for( Empregado x : staff ) {
			System.out.println(x);
		}
		
		System.out.println(" " );
		System.out.print("Id do funcionario a receber o aumento: " );
		int funcionario = sc.nextInt();
		System.out.print("Informe o percentual de aumento: " );
		double percentual = sc.nextDouble();
		
		for( Empregado x : staff ) {
			if ( x.getId() == funcionario ) {
				x.mudaSalario(percentual);
			}
		}
		
		System.out.println(" " );
		System.out.println("Empregados registrados:" );
		
		for( Empregado x : staff ) {
			System.out.println(x);
		}

		System.out.println(" " );
		System.out.print("Id do funcionario a receber o aumento: " );
		int id = sc.nextInt();
		
		Empregado func = staff.stream().filter( x -> x.getId() == id ).findFirst().orElse(null);
		
		if(func == null ) {
			System.out.println("Funcionario nao encontrado");
		} else {
			System.out.print("Informe o percentual de aumento: " );
			percentual = sc.nextDouble();
			
			func.mudaSalario(percentual);
			
		}
		
		System.out.println(" " );
		System.out.println("Empregados registrados:" );
		
		for( Empregado x : staff ) {
			System.out.println(x);
		}

		sc.close();
	}

}
