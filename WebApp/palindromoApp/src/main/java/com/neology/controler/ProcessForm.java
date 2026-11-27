/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neology.controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

/**
 *
 * @author Kirvan Suarez
 */
@WebServlet(name="ValidateWord", urlPatterns = "/palindrome")
public class ProcessForm extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException, ServletException {
        // Codificación para acentos y caracteres especiales
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        // Lectura de parametros de entrada por atributo, limpieza de espacios y conversion a minusculas
        String textWord = request.getParameter("word").trim().toLowerCase();
        Word  w = new Word();
        PrintWriter out = response.getWriter();
        
        try{
            // Validacion de dato
            if(w.isValid(textWord)) {
                 response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // Código 400
                 out.print("{\"mensaje\": \"Introduce una palabra valida y vuelvelo a intentar.\"}");
                 return;
            }

            response.setStatus(HttpServletResponse.SC_OK); // Código 200
             String cleanData = textWord.replace("\"", "\\\"");

            if(w.isPalindrome(textWord)) {
                out.print("{\"mensaje\": \"¡La palabra '" + cleanData + "' es palindomo.!\"}");

            }else {
                out.print("{\"mensaje\": \"¡La palabra '" + cleanData + "' NO es palindomo.!\"}");

            }
        } catch(Exception e) {
            // Error inesperado
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Código 500
            out.print("{\"mensaje\": \"Error interno en el servidor: " + e.getMessage() + "\"}");
        } finally {
            out.flush();
        }
    }
    
}
