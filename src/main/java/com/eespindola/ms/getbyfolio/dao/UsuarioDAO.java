package com.eespindola.ms.getbyfolio.dao;

import com.eespindola.ms.getbyfolio.models.UsuarioML;
import com.eespindola.ms.getbyfolio.utils.Result;

public interface UsuarioDAO {

    Result<UsuarioML> GetByFolio(String folioId);

}
