package com.example.sreiw.repositories;

import com.example.sreiw.entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsuarioReposi extends JpaRepository<Usuario, Integer> {

    @Modifying
    @Transactional
    @Query(value =
            "CALL sp_crear_usuario(:id, :tipo, :nombres, :apellidos, :correo, :contrasena)",
            nativeQuery = true)
    void crearUsuario(
            Integer id, Integer tipo, String nombres,
            String apellidos, String correo, String contrasena
    );

    @Modifying
    @Transactional
    @Query(value = "CALL sp_desactivar_usuario(:id)", nativeQuery = true)
    void desactivarUsuario(Integer id);

    @Query(value =
            "SELECT * FROM fn_login_usuario(:correo, :contrasena)",
            nativeQuery = true)
    List<Object[]> login(String correo, String contrasena);

    @Query(value =
            "SELECT id_usuario, nombres, id_tipousuario FROM usuario",
            nativeQuery = true)
    List<Object[]> listarUsuarios();
}
