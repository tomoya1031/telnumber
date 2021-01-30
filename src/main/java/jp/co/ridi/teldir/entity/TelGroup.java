package jp.co.ridi.teldir.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TelGroup {

	@Id
	@GeneratedValue
	private Long groupId;

	private String groupName;

}
