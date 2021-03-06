package pwingei.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pwingei.entity.PwingeiEntity;
import pwingei.repository.PwingeiRepository;

@Service
@Slf4j
public class PwingeiService {

	@Autowired
	PwingeiRepository pwingeiRepository;
	

	public List<PwingeiEntity> findAllPwingei(){
		return pwingeiRepository.findAll();
	}
		

    public Optional < PwingeiEntity > findById(Long id) {
        return pwingeiRepository.findById(id);
    }
}
