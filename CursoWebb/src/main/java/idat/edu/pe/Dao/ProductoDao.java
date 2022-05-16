package idat.edu.pe.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import idat.edu.pe.Entity.Producto;

public interface ProductoDao extends JpaRepository<Producto, Integer> {

}
