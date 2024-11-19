package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControleAcessoDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static String perfilUsuario;

    public static void setPerfilUsu(String perfil) {

        perfilUsuario = perfil;

    }

    public static String getPerfilUsu() {
        return perfilUsuario;
    }

}