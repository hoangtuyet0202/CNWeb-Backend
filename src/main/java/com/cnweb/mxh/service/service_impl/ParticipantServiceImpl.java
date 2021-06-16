package com.cnweb.mxh.service.service_impl;

import com.cnweb.mxh.model.Participant;
import com.cnweb.mxh.repository.ParticipantRepository;
import com.cnweb.mxh.repository.impl.ParticipantRepositoryImpl;
import com.cnweb.mxh.service.ParticipantService;

import java.util.List;

public class ParticipantServiceImpl implements ParticipantService {
    private ParticipantRepository participantRepository = new ParticipantRepositoryImpl();

    @Override
    public Participant insert(Participant participant) {
        int id = participantRepository.insert(participant);
        return participantRepository.findById(id);
    }

    @Override
    public Participant update(Participant participant) {
        participantRepository.update(participant);
        return participantRepository.findById(participant.getId());
    }

    @Override
    public Participant findById(int id) {
        return participantRepository.findById(id);
    }

    @Override
    public List<Participant> findAll() {
        return participantRepository.findAll();
    }
}
