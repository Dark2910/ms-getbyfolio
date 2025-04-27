package com.eespindola.ms.getbyfolio.dao.Implementation;

import com.eespindola.ms.getbyfolio.dao.Mapper.UsuarioMapper;
import com.eespindola.ms.getbyfolio.dao.UsuarioDAO;
import com.eespindola.ms.getbyfolio.models.UsuarioML;
import com.eespindola.ms.getbyfolio.utils.Constantes;
import com.eespindola.ms.getbyfolio.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UsuarioDAOImp implements UsuarioDAO {

    @Autowired
    @Qualifier(Constantes.HIKARI_CONNECTION)
    private JdbcTemplate jdbcTemplate;

    public UsuarioDAOImp(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Result<UsuarioML> GetByFolio(String folioId) {

        Result<UsuarioML> result = new Result<>();
        String query = Constantes.Usuario_GET_BY_FOLIO;

        try{
            result.object = jdbcTemplate.query(query, new UsuarioMapper(), folioId).get(0);
            result.isCorrect = true;

        } catch (Exception e) {
            result.isCorrect = false;
            result.exception = e;
            result.message = e.getLocalizedMessage();
        }

        return result;
    }
}
