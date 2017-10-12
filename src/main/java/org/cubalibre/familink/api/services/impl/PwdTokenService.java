package org.cubalibre.familink.api.services.impl;

import org.cubalibre.familink.api.entite.PwdToken;
import org.cubalibre.familink.api.repository.PwdTokenRepository;
import org.cubalibre.familink.api.services.IPwdTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "pwdTokenService")
public class PwdTokenService implements IPwdTokenService {

    @Autowired
    private PwdTokenRepository pwdTokenRepository;

    @Override
    public PwdToken create(PwdToken newPwdToken) {

        return pwdTokenRepository.save(newPwdToken);
    }

    @Override
    public PwdToken getPwdTokenById(int id) {
        return pwdTokenRepository.findOne(id);
    }

    @Override
    public void update(PwdToken pwdTokenToUpdate) {

        final PwdToken toUpdate = pwdTokenRepository.findOne(pwdTokenToUpdate.getId());

        if (toUpdate != null) {
            toUpdate.setUsed(pwdTokenToUpdate.isUsed());
            pwdTokenRepository.save(toUpdate);
        }
    }
}
