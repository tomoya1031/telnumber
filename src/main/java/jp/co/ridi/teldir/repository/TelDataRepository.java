package jp.co.ridi.teldir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.ridi.teldir.entity.TelData;

@Repository
public interface TelDataRepository extends JpaRepository<TelData, Long> {

}
