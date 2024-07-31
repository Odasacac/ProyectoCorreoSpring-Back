package ccasolutions.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ccasolutions.modelos.Usuario;

public interface IUsuarioDao extends CrudRepository <Usuario, Long>
{
	@Modifying
	@Query ("UPDATE Usuario u SET u.esAdmin = true WHERE u.id = :usuarioId")
	int hacerAdmin(@Param("usuarioId") Long usuarioId);
	
	@Modifying
	@Query ("UPDATE Usuario u SET u.esAdmin = false WHERE u.id = :usuarioId")
	int deshacerAdmin(@Param("usuarioId") Long usuarioId);
	
	//Para ver si es Administrador un Usuario
	@Query("SELECT u.esAdmin FROM Usuario u WHERE u.id = :usuarioId")
	Boolean esAdminElUsuario(@Param("usuarioId") Long usuarioId);
	
	
}
