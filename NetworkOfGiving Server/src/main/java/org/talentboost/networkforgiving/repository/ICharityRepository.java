package org.talentboost.networkforgiving.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.talentboost.networkforgiving.model.Charity;

@Repository
public interface ICharityRepository extends JpaRepository<Charity, Integer> {

}
