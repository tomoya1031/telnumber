package jp.co.ridi.teldir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ridi.teldir.dto.EditDto;
import jp.co.ridi.teldir.entity.TelData;
import jp.co.ridi.teldir.repository.TelDataRepository;
import jp.co.ridi.teldir.util.BeanUtil;

@Service
public class EditService {
	
	@Autowired
	private TelDataRepository telDataRepository;

	public TelData findTelData(Long id) {
		return telDataRepository.getOne(id);
	}

	public void saveTelData(EditDto dto) {
		telDataRepository.save(BeanUtil.createProperties(dto, TelData.class));
	}

}
