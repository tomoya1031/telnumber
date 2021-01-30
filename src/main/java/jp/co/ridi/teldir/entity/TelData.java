package jp.co.ridi.teldir.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TelData {

	@Id
	@GeneratedValue
	private Long id;

	private String userName;

	private String telNo;

	private String mailAddr;

}
