package br.com.concessionaria.dto;

public class VendaDTO {
	
	private double totalVendas;

	public VendaDTO() {
		super();
	}

	public VendaDTO(double totalVendas) {
		super();
		this.totalVendas = totalVendas;
	}

	public double getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(double totalVendas) {
		this.totalVendas = totalVendas;
	}	
}
