package idat.edu.pe.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.Dao.ProductoDao;
import idat.edu.pe.Entity.Producto;

@Service
@Transactional
public class ProductoService {
	
	@Autowired
	private ProductoDao productoDao;
	
	public List<Producto> buscarTodo(){
		return (ArrayList<Producto>) productoDao.findAll();
	}
	
	public Producto crear(Producto producto) {
		return productoDao.save(producto);
	}
	
	public Producto actualizar (Producto productoActualizar) {
		
		Producto productoActual = productoDao.findById(productoActualizar.getIdProducto()).get();
		
		productoActual.setIdProducto(productoActualizar.getIdProducto());
		productoActual.setNombre(productoActualizar.getNombre());
		productoActual.setDescripcion(productoActualizar.getDescripcion());
		productoActual.setPrecio(productoActualizar.getPrecio());
		productoActual.setEstado(productoActualizar.getEstado());
		
		Producto productoActualizado = productoDao.save(productoActual);

		return productoActualizado;
				
	}
	
	public Producto buscarPorId(Integer idProducto) {
		return productoDao.findById(idProducto).get();
	}
	
	public void Eliminar(Integer idProducto) {
		productoDao.deleteById(idProducto);
	}

}
