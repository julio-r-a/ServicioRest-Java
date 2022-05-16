package idat.edu.pe.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import idat.edu.pe.Entity.Producto;
import idat.edu.pe.Service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {
	
	@Autowired
	ProductoService productoService;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Producto> listaProductos = productoService.buscarTodo();
		return new ResponseEntity<>(listaProductos,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{idProducto}")
	@ResponseBody
	public ResponseEntity<Object>buscarPorId(@PathVariable("idProducto") int idProducto){
		Producto producto = productoService.buscarPorId(idProducto);
		if (producto == null)

			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Object>(producto, HttpStatus.OK);
	}
			
	@PostMapping
	public ResponseEntity<Object> crear(@RequestBody Producto producto){
		System.out.println("Se Agrego correctamente");
		return new ResponseEntity<Object>(productoService.crear(producto)
				, HttpStatus.OK);

	}
	
	@PutMapping(value = "/{idProducto}")
	public ResponseEntity<Object> actualizar(@PathVariable("idProducto") int idProducto,@RequestBody Producto producto){
		return new ResponseEntity<Object>(productoService.actualizar(producto),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{idProducto}")
	public ResponseEntity<Object> borrar(@PathVariable("idProducto") int idProducto) {
		productoService.Eliminar(idProducto);
		return new ResponseEntity<Object>(HttpStatus.OK);

	}
	
}
