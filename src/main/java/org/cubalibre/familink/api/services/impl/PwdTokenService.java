package org.cubalibre.familink.api.services.impl;

import org.cubalibre.familink.api.entite.PwdToken;
import org.cubalibre.familink.api.repository.PwdTokenRepository;
import org.cubalibre.familink.api.services.IPwdTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "pwdTokenService")
public class PwdTokenService implements IPwdTokenService {

    @Autowired
    private PwdTokenRepository pwdTokenRepository;

    @Override
    public List<PwdToken> getPwdTokens() {

        return pwdTokenRepository.findAll();
    }

    @Override
    public PwdToken create(PwdToken newPwdToken) {

        return pwdTokenRepository.save(newPwdToken);
    }

    @Override
    public PwdToken getPwdTokenById(int id) {
        return pwdTokenRepository.findOne(id);
    }

    @Override
    public void update(PwdToken toUpdate) {

        final PwdToken pwdTokenToUpdate = pwdTokenRepository.findOne(toUpdate.getId());

        if (toUpdate != null) {
            pwdTokenToUpdate.setToken(toUpdate.getToken());
            pwdTokenToUpdate.setUsed(toUpdate.isUsed());
            pwdTokenRepository.save(pwdTokenToUpdate);
        }
    }

    @Override
    public void deletePwdToken(int id) {

        pwdTokenRepository.delete(id);
    }
}
