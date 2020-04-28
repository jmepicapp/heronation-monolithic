package com.hackathlon.heronation.auth;

import com.hackathlon.heronation.model.dto.UsuarioDTO;
import com.hackathlon.heronation.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdicionalToken implements TokenEnhancer {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        UsuarioDTO usuarioDTO = usuarioService.findByUsername(oAuth2Authentication.getName()).get();

        Map<String, Object> info = new HashMap<>();
        info.put("info adicional", oAuth2Authentication.getName());

        info.put("usuario: "+ usuarioDTO.getId() + ", email_usuario", usuarioDTO.getEmail());

        ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }
}
