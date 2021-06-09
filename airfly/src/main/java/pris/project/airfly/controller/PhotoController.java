package pris.project.airfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pris.project.airfly.entity.Flight;
import pris.project.airfly.entity.Photo;
import pris.project.airfly.repository.PhotoRepository;

@Controller
@RequestMapping(value="/photos")
@CrossOrigin(origins = "http://localhost:4200")
public class PhotoController {
	
	@Autowired
	PhotoRepository photoRepository;
	
	@GetMapping(value="/getPhotosForPlane/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Photo>> getPhotosForPlane(@PathVariable Integer id){

		return new ResponseEntity<List<Photo>>(photoRepository.findPhotosForFlight(id), HttpStatus.OK);
	}

}
