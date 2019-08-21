/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import DATA.FilaDAO;
import UTIL.Criptografia;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author Jonatas Teodoro
 */
@WebServlet(name = "CadastrarNaFila", urlPatterns = {"/CadastrarNaFila"})
public class CadastrarNaFila extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {

            Criptografia criptografia = new Criptografia();
            String nome = criptografia.hexToAscii(request.getParameter("nome")).toUpperCase();
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            String type = "";
            if(tipo==0){
                type="AVIÃO";
            }else{
                type="HELICÓPTERO";
            }

            FilaDAO dao;

            dao = new FilaDAO();
            boolean cond1 = dao.agendar(nome, type);

            String json = "";

            if (cond1) {
                json = "{\"retorno\" : \"0\"}";
            } else {
                json = "{\"retorno\" : \"1\"}";
            }

            HttpServletResponse f = new HttpServletResponseWrapper(response);
            f.getWriter().print(json);

        } catch (Exception ex) {
            System.out.println("Erro ao CadastrarNaFila!Erro: " + ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
