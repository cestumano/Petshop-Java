package entities;

import java.util.ArrayList;
import java.util.List;

public class Clinica {
	
	private List<Animal> animaisRegistrados;
	private List<String> historicosMedicos;
	
	
	public Clinica() {
		
		animaisRegistrados = new ArrayList<>();
        historicosMedicos = new ArrayList<>();
	}


	public List<Animal> getAnimaisRegistrados() {
		return animaisRegistrados;
	}


	public void setAnimaisRegistrados(List<Animal> animaisRegistrados) {
		this.animaisRegistrados = animaisRegistrados;
	}


	public List<String> getHistoricosMedicos() {
		return historicosMedicos;
	}


	public void setHistoricosMedicos(List<String> historicosMedicos) {
		this.historicosMedicos = historicosMedicos;
	}
	
	//Registrar um novo Animal
	
	public void registrarAnimal(Animal animal) {
		animaisRegistrados.add(animal);
		historicosMedicos.add("");
	}
	
	//Remover um animal
	
	public void removerRegistro(Animal animal) {
		int index = animaisRegistrados.indexOf(animal);
		if (index != -1) {
			animaisRegistrados.remove(index);
			historicosMedicos.remove(index);
		}
	}
	
	//Listar Animais
	
	public void listarAnimais() {
		for (Animal animal : animaisRegistrados) {
			System.out.println(animal);
		}
	}
	
	//Adicionar historico animal
	
	public void adicionarHistoricoMedico(Animal animal, String dataFormatada, String sintomas, String diagnostico, String tratamento, String observacoes) {
        int index = animaisRegistrados.indexOf(animal);
        if (index != -1) {
        	String historicoAnimal = historicosMedicos.get(index);
            historicoAnimal += "Data:" + dataFormatada + "\n";
            historicoAnimal += "Sintomas:" + sintomas + "\n";
            historicoAnimal += "Diagnóstico:" + diagnostico + "\n";
            historicoAnimal += "Tratamento:" + tratamento + "\n";
            historicoAnimal += "Observações:" + observacoes + "\n";
            historicosMedicos.set(index, historicoAnimal);
        }
	}
	
	//Listar historico animal
	
	public void listarHistoricosMedicos() {
		for (int i=0; i < animaisRegistrados.size(); i++) {
			Animal animal = animaisRegistrados.get(i);
			String historicoAnimal = historicosMedicos.get(i);
			System.out.println("Histórico médico do Pet " + animal.getNome() + ":");
            System.out.println(historicoAnimal);
            System.out.println("-----------------------------------------");
		}
	}
	
	// Verificar se o animal existe
	
	public boolean animalExiste(String nomeAnimal) {
		for (Animal animal : animaisRegistrados) {
			if (animal.getNome().equalsIgnoreCase(nomeAnimal)) {
				return true;
			}
		}
		return false;
	}
	
	// Encontrar animal registrado
	
	public Animal encontrarAnimalPorNome(String nomeAnimal) {
		for (Animal animal : animaisRegistrados) {
			if (animal.getNome().equalsIgnoreCase(nomeAnimal)) {
				return animal;
			}
		}
		return null;
	}
	
	
//Listra hiostórico medico do animal
	
	public void listarHistoricosMedicos(Animal animal) {
		int index = animaisRegistrados.indexOf(animal);
		if (index != -1) {
			String historicoAnimal = historicosMedicos.get(index);
			System.out.println("Histrorico médico do Pet" + animal.getNome() + ":");
			System.out.println(historicoAnimal);
		}else {
			System.out.println("Histórico médico não encontrado para o animal"+ animal.getNome());
		}
	}

}
