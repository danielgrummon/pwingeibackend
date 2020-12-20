package pwingei.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import pwingei.entity.PwingeiEntity;
import pwingei.service.PwingeiService;


@CrossOrigin(origins = "https://pwingei-backend.herokuapp.com")
@Slf4j
@RestController
@RequestMapping(value = "/app/rest/wingei", produces = MediaType.APPLICATION_JSON_VALUE)
public class PwingeiController {
	
	@Autowired
	private PwingeiService pwingeiService;

	@GetMapping("/findAll")
	//@CrossOrigin(origins = "*")
	public List<PwingeiDto> getWingeiList() {
		return transformToPwingeiDto(pwingeiService.findAllPwingei());
	}
	
	
    @GetMapping(path = {"/{id}"})
    //@CrossOrigin(origins = "*")
    public PwingeiEntity findOne(@PathVariable("id") int id){
        return pwingeiService.findById(id).get();
    }
	
	private List<PwingeiDto> transformToPwingeiDto(Collection<PwingeiEntity> pwingeiList){
		return pwingeiList.stream().map(PwingeiDto::new).collect(Collectors.toList());
	}
	
	private List<PwingeiEntity> transformToPwingeiEntity(Collection<PwingeiDto> pwingeiDtoList){
		return pwingeiDtoList.stream().map(PwingeiDto::toEntity).collect(Collectors.toList());
	}

}
