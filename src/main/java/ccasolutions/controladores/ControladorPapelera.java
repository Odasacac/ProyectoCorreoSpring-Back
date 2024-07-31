package ccasolutions.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ccasolutions.respuesta.RespuestaMensajes;
import ccasolutions.servicios.IServicioMensajes;

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class ControladorPapelera 
{
	
	@Autowired
	private IServicioMensajes servicioMensajes;
	
	@DeleteMapping("/papelera/{id}")
	public ResponseEntity<RespuestaMensajes> borrarMensajePorId(@PathVariable("id") Long id)
	{
		return servicioMensajes.borrarMensajePorId(id);
	}
	
	@PutMapping("/papelera/{id}")
	public ResponseEntity<RespuestaMensajes> sacarDePapelera(@PathVariable("id") Long id)
	{
		return servicioMensajes.sacarDePapelera(id);
	}
	
	@GetMapping("/papelera/{id}")
	public ResponseEntity<RespuestaMensajes> mostrarPapelera(@PathVariable("id") Long id)
	{
		return servicioMensajes.mostrarPapelera(id);
	}
}
