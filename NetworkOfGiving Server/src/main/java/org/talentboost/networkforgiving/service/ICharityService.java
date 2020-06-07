package org.talentboost.networkforgiving.service;

import org.talentboost.networkforgiving.model.Charity;

import java.util.List;

public interface ICharityService {
    Charity getCharity(int id);

    List<Charity> getAll();

    Charity createCharity(Charity charity);

    void updateCharity(int id, Charity charity);

    void deleteCharity(int id);
}
