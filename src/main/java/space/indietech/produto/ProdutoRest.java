package space.indietech.produto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRest {

	private List<Produto> lista = new ArrayList<>();

	@GetMapping
	public ResponseEntity<List<Produto>> getVarios() {
		for (Produto produto : lista) {
			if (produto.getNome().equals(lista))
				;
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{nome}")
	public ResponseEntity<Produto> get(@PathVariable("nome") String nome) {
		for (Produto produto : lista) {
			if (produto.getNome().equals(nome))
				return ResponseEntity.ok(produto);
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{nome}")
	public ResponseEntity<Produto> set(@PathVariable("nome") String nome, @RequestBody Produto produto) {
		lista.add(produto);
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping("/{nome}")
	public ResponseEntity<Produto> delete(@PathVariable("nome") String nome){
		Iterator<Produto> itt = lista.iterator();
		while(itt.hasNext()) {
			Produto produto = itt.next();
			if(produto.getNome().equals(nome)) {
				itt.remove();
			}
		}
		return ResponseEntity.ok().build();
	}
}