package ccasolutions.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ccasolutions.respuesta.RespuestaMensajes;

import ccasolutions.servicios.IServicioMensajes;


@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class ControladorMensajesEnviados 
{
	@Autowired
	private IServicioMensajes servicioMensajes;
	
	@GetMapping("/mensajesenviados/{id}")
	public ResponseEntity<RespuestaMensajes> buscarMensajePorEmisorId(@PathVariable("id")  Long id)
	{
		return servicioMensajes.buscarMensajePorEmisorId(id);
	}
	


}
