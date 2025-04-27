package com.eespindola.ms.getbyfolio.jpa.Mapper;

import com.eespindola.ms.getbyfolio.jpa.Entities.UsuarioJPA;
import com.eespindola.ms.getbyfolio.models.UsuarioML;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;

public class UsuarioMapper {

    public static @NotNull UsuarioML Map(@NotNull UsuarioJPA usuarioJPA){

        UsuarioML usuarioML = new UsuarioML();

        usuarioML.setIdUsuario(usuarioJPA.getIdUsuario());
        usuarioML.setFolio(usuarioJPA.getFolio());
        usuarioML.setNombre(usuarioJPA.getNombre());
        usuarioML.setApellidoPaterno(usuarioJPA.getApellidoPaterno());
        usuarioML.setApellidoMaterno(usuarioJPA.getApellidoMaterno());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = simpleDateFormat.format(usuarioJPA.getFechaNacimiento()).toString();

        usuarioML.setFechaNacimiento(fecha);

        usuarioML.setUsername(usuarioJPA.getUsername());
        usuarioML.setEmail(usuarioJPA.getEmail());
        usuarioML.setPassword(usuarioJPA.getPassword());
        usuarioML.setStatus(usuarioJPA.getStatus());

        return usuarioML;
    }

}
