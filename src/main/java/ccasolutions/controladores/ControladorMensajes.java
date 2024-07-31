package ccasolutions.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ccasolutions.modelos.Mensaje;

import ccasolutions.respuesta.RespuestaMensajes;

import ccasolutions.servicios.IServicioMensajes;


@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class ControladorMensajes 
{
	@Autowired
	private IServicioMensajes servicioMensajes;
	
	
	
	@PostMapping("/mensajes")
	public ResponseEntity<RespuestaMensajes> guardarMensaje(@RequestBody Mensaje mensaje)
	{
		return servicioMensajes.guardar(mensaje);
	}
	
	
	@GetMapping("/mensajes")
	public ResponseEntity<RespuestaMensajes> buscarMensajePorEmisorIdYReceptorId(@RequestParam("EmisorId") Long emisorId, @RequestParam("ReceptorId") Long receptorId)
	{
		return servicioMensajes.buscarMensajePorEmisorIdYReceptorId(emisorId, receptorId);
	}
	
	@GetMapping("/mensajes/{id}")
	public ResponseEntity<RespuestaMensajes> buscarMensajePorId(@PathVariable("id") Long id)
	{
		return servicioMensajes.buscarMensajePorId(id);
	}
	
	
	@PutMapping("/mensajes/{id}")
	public ResponseEntity<RespuestaMensajes> enviarAPapelera(@PathVariable("id") Long id)
	{
		return servicioMensajes.enviarAPapelera(id);
	}
	

}
