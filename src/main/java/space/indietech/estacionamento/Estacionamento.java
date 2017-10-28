package space.indietech.estacionamento;

import javax.persistence.Id;

public class Estacionamento {
	
	@Id
	private int andar;
	private int vagas;
	private String descricao;

	public Estacionamento() {
		super();
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
