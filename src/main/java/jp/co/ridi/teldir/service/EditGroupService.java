package jp.co.ridi.teldir.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ridi.teldir.dto.EditGroupDto;
import jp.co.ridi.teldir.entity.TelGroup;
import jp.co.ridi.teldir.repository.TelGroupRepository;
import jp.co.ridi.teldir.util.BeanUtil;

@Service
public class EditGroupService {
	
	@Autowired
	private TelGroupRepository telGroupRepository;

	public TelGroup findTelData(Long groupId) {
		return telGroupRepository.getOne(groupId);
	}

	public void saveTelGroup(EditGroupDto dto) {
		telGroupRepository.save(BeanUtil.createProperties(dto, TelGroup.class));
	}

}
