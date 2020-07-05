package br.com.william.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que gera as tabelas, automaticamente, no banco de dados
 * antes de salvar os valores
 * 
 * @author Breno
 * @version 1.0
 * @since 15/05/2017
 */
public class GerarTabelas {

	/**
	 * Método principal
	 */
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("empresa");
		factory.close();

	}
}
