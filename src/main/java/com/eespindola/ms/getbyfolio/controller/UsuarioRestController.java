package com.eespindola.ms.getbyfolio.controller;

import com.eespindola.ms.getbyfolio.dao.Implementation.UsuarioDAOImp;
import com.eespindola.ms.getbyfolio.models.UsuarioML;
import com.eespindola.ms.getbyfolio.utils.Result;
import com.eespindola.ms.getbyfolio.jpa.UsuarioRepository;
import com.eespindola.ms.getbyfolio.utils.FolioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;

@RestController
@RequestMapping("/usuarioAPI")
public class    UsuarioRestController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioDAOImp UsuarioImp;

    @PostMapping("/{folioId}")
    public Result<UsuarioML> GetByFolio(@RequestHeader(value = "folioRequest", required = false) String folioRequest, @PathVariable String folioId){

        folioRequest = (folioRequest == null || folioRequest.isEmpty() || folioRequest.isBlank())? FolioRequest.CrearFolioRequest() : folioRequest;

        Result<UsuarioML> result = new Result<>();

        try {
//            Optional<UsuarioJPA> usuario = usuarioRepository.findByFolio(folioId);
//
////            result.object = usuario.map(usuarioJPA -> UsuarioMapper.Map(usuarioJPA));
//            result.object = usuario.map(UsuarioMapper::Map);


            result = UsuarioImp.GetByFolio(folioId);
            result.message = MessageFormat.format("Folio: {0}",folioRequest);
            result.isCorrect = true;

        } catch (Exception e){
            result.isCorrect = false;
            result.exception = e;
            result.message = e.getLocalizedMessage();
        }
        return result;
    }


}
