package space.indietech.estacionamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import space.indietech.produto.Produto;

@RestController
@RequestMapping(value = "/Estacionamento")
public class EstacionamentoRest {

	Estacionamento[][] estacionamento = new Estacionamento[4][60];

	public EstacionamentoRest() {
		for (int andar = 0; andar < 4; andar++) {
			for (int vagas = 0; vagas < 60; vagas++) {

				Estacionamento estacionamento = new Estacionamento();
				estacionamento.setAndar(1);
				estacionamento.setVagas(60);
				estacionamento.setDescricao("Livre");
				this.estacionamento[andar][vagas] = estacionamento;

			}
		}
	}

	private String ocupadoLivre() {
		Random rand = new Random();
		if (rand.nextBoolean()) {
			return "livre";
		}
		return "ocupado";
	}

	@GetMapping
	public ResponseEntity<Estacionamento[][]> getEstacionamento() {
		return ResponseEntity.ok(estacionamento);
	}

	@GetMapping("/{andar}")
	public ResponseEntity<Estacionamento[]> get(@PathVariable("andar") int andar) {
		for (Estacionamento[] estacionamento : estacionamento) {
			if (estacionamento.length == andar)
				return ResponseEntity.ok(estacionamento);
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{andar}/{numero}")
	public ResponseEntity<Estacionamento[]> set(@PathVariable("andar") int andar, @PathVariable("numero") int numero,
			@RequestBody Estacionamento estacionamento) {

		this.estacionamento[andar][numero].setDescricao(estacionamento.getDescricao());
		return ResponseEntity.ok().build();
	}

	@GetMapping("/vagasLivres")
	public ResponseEntity<List> getLivre() {
		List<Estacionamento> vagaLivre = new ArrayList<>();
		for (int andar = 0; andar < 4; andar++) {
			for (int numero = 0; numero < 60; numero++) {
				if (estacionamento[andar][numero].getDescricao().equals("livre")) {
					vagaLivre.add(estacionamento[andar][numero]);
				}
			}
		}
		return ResponseEntity.ok(vagaLivre);
	}

	@GetMapping("/vagasOcupadas")
	public ResponseEntity<List> getOcupado() {
		List<Estacionamento> vagasOcupadas = new ArrayList<>();
		for (int andar = 0; andar < 4; andar++) {
			for (int numero = 0; numero < 60; numero++) {
				if (estacionamento[andar][numero].getDescricao().equals("ocupado")) {
					vagasOcupadas.add(estacionamento[andar][numero]);
				}
			}
		}
		return ResponseEntity.ok(vagasOcupadas);
	}

}