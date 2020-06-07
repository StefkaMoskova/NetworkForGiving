package org.talentboost.networkforgiving.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talentboost.networkforgiving.model.Charity;
import org.talentboost.networkforgiving.repository.ICharityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CharityService implements ICharityService {
    @Autowired
    private ICharityRepository charityRepository;

    @Override
    public Charity getCharity(int id) {
        return charityRepository.findById(id).orElse(null);
    }

    @Override
    public List<Charity> getAll() {
        return charityRepository.findAll();
    }

    @Override
    public Charity createCharity(Charity charity) {
        return charityRepository.save(charity);
    }

    @Override
    public void updateCharity(int id, Charity charity) {
        Optional<Charity> charityOptional = charityRepository.findById(id);
        if (charityOptional.isPresent()) {
            charity.setId(id);
            charityRepository.save(charity);
        }
    }

    @Override
    public void deleteCharity(int id) {
        if (charityRepository.findById(id).isPresent()) {
            charityRepository.deleteById(id);
        }
    }
}
