package br.com.rodrigo.poo;

public class Carro {
	
	//Contrutor
	public Carro(String cor, String marca, String modelo) {
		this.cor = cor;
		this.marca = marca;
		this.modelo = modelo;		
	}
	
	//Todo carro será azul
	public Carro(String marca, String modelo) {
		this.cor = "Azul";
		this.marca = marca;
		this.modelo = modelo;		
	}
	
	
	//Atributos
	private String cor;
	private String marca;
	private String modelo;
	
	//Métodos
	public void andar() {
		System.out.println("Carro andando...");
	}
	
	public void parar() {
		System.out.println("Carro parado.");
	}
	
	//GETs e SETs
	//Cor
	public String getCor() {
		return this.cor;
	}	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	//Marca
	public String getMarca() {
		return this.marca;
	}	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	//Modelo
	public String getModelo() {
		return this.modelo;
	}	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}	
	
	@Override
	public String toString() {		
		return "Cor: " + cor + "\nMarca: " + marca + "\nModelo: " + modelo;
	}
}
