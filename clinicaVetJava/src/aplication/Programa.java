package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Animal;
import entities.Cao;
import entities.Clinica;
import entities.Gato;

public class Programa {
	
//	private static Animal animal;

	public static void main(String[] args) {
		Clinica clinica = new Clinica();
		Scanner scanner = new Scanner(System.in);
		
		boolean executando = true;
		while (executando) {
			System.out.println("-----------------------------------");
            System.out.println("MENU");
            System.out.println("1. Registrar Animal");
            System.out.println("2. Remover Registo");
            System.out.println("3. Listar Animais");
            System.out.println("4. Adicionar Histórico Médico");
            System.out.println("5. Listar Hitórico Médico");
            System.out.println("6. Listar Histórico Médico de um Animal ");
            System.out.println("7. Sair");
            System.out.println("Digite a opção desejada: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
            
            //registrar animal
            case 1:
            	scanner.nextLine();
            	try {
            		String nome = readNonEmptyInput(scanner, "Digite o nome do animal: ");
            		String especie = readNonEmptyInput(scanner, "Digite a especie do animal: ");
                    String dono = readNonEmptyInput(scanner, "Digite o nome do dono do animal: ");

                    int tipoAnimal;
                    
                    do{
                        System.out.println("O animal é um cão (1) ou um gato (2)? ");
                        tipoAnimal = Integer.parseInt(scanner.nextLine());
                        if (tipoAnimal == 1) {
                            String raca = readNonEmptyInput(scanner, "Digite a raça do cão: ");
                            Cao cao = new Cao(nome, especie, dono, raca);
                            clinica.registrarAnimal(cao);
                            System.out.println("Cão registrado com sucesso!");
                    }else if (tipoAnimal == 2) {
                        String tipoPelagem = readNonEmptyInput(scanner, "Digite o tipo de pelagem do gato: ");
                        Gato gato = new Gato(nome, especie, dono, tipoPelagem);
                        clinica.registrarAnimal(gato);
                        System.out.println("Gato registrado com sucesso!");
                    }else{
                        System.out.println("Opção inválida!");
                    }
                }while(tipoAnimal <= 0 || tipoAnimal >= 3);
            } catch (NumberFormatException e){
                System.out.println("Esceção capturada: " + e.getMessage());
            } 
                
            break;
            
            //Remover Animal
            
            case 2:
            	try {
            		scanner.nextLine();
            		String nomeAnimal = readNonEmptyInput(scanner, "Digite o nome do animal a ser removido: ");
            		
            		for (Animal animal : clinica.getAnimaisRegistrados()) {
            			if (animal.getNome().equalsIgnoreCase(nomeAnimal)) {
            				clinica.removerRegistro(animal);
            				System.out.println("Registro removido com sucesso.");
            				break;
            			}else {
            				System.out.println("Animal não encontrado.");
            			}
            		}
            		
            		break;
            	} catch (Exception e) {
            		System.out.println("Exceção capturada: " + e.getMessage());
            	}
            	
            	//Listar animal
            	
            case 3:
            	System.out.println();
            	clinica.listarAnimais();
            	break;
            	
            case 4:
            	scanner.nextLine();
            	String nomeAnimalHistorico = readNonEmptyInput(scanner,"Digite o nome do animal para adicionar histórico médico: ");
            	for (Animal animal : clinica.getAnimaisRegistrados() ) {
            		if(animal.getNome().equalsIgnoreCase(nomeAnimalHistorico)) {
            			System.out.println("Digite a data do histórico médico (dd/MM/yyyy");
                        String dataString = scanner.nextLine();
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                        	Date data = dateFormatter.parse(dataString);
                            String dataFormatada = dateFormatter.format(data);
                            
                            System.out.println("Digite a descrição dos sintomas: ");
                            String sintomas = scanner.nextLine();
                            
                            System.out.println("Digite o diagnóstico: ");
                            String diagnostico = scanner.nextLine();
                            
                            System.out.println("Digite o tratamento: ");
                            String tratamento = scanner.nextLine();
                            
                            System.out.println("Digite as observações: ");
                            String observacoes = scanner.nextLine();
                            
                            clinica.adicionarHistoricoMedico(animal, dataFormatada, sintomas, 
                                    diagnostico, tratamento, observacoes);
                            System.out.println("Historico médico adicionado com sucesso!");
                            break;
                        }catch (ParseException e) {
                        	System.out.println("Data inválida! Certifique-se de usar o formato dd/MM/yyyy.");
                            return;
                        }catch (Exception e) {
                            System.out.println("Exceção capturada: " + e.getMessage());
                        }
                        
            		}else{
                    	System.out.println("Animal não encotrado!");
                    }
            		
            	}
            	break;
            	
            case 5:
            	System.out.println();
                clinica.listarHistoricosMedicos();
                break;
                
                //Listar historico do animal
                
            case 6:
            	try {
            		scanner.nextLine();
            		String nomeAnimal = readNonEmptyInput(scanner, "Digite o nome do animal: ");
            		
            		for (Animal animal : clinica.getAnimaisRegistrados()) {
            			if (animal.getNome().equalsIgnoreCase(nomeAnimal)) {
            				clinica.listarHistoricosMedicos(animal);
                            System.out.println("Historico medico do animal encontrado!");
                            break;
            			}else {
                            System.out.println("Historico medico do animal não encontrado!");

            			}
            		}
            		
            		break;
            	
            	}catch (Exception e){
                    System.out.println("Exceção capturada: " + e.getMessage());
                }
            	
            case 7:
                System.out.println("Consulta Finalizada!");
                System.exit(0);                  
            break;
            default:
            }
            }
            
            
		}
	

	private static String readNonEmptyInput(Scanner scanner, String message){
        System.out.println(message);
        String input = scanner.nextLine();
        
        if (input.isEmpty()){
            System.out.println("A entrada não pode ser vazia. Por favor, Digite novamente. \n");
            return readNonEmptyInput(scanner, message);
        }
        return input;
	}

}

