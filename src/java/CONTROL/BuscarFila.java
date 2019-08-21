/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import DATA.FilaDAO;
import MODEL.Fila;
import MODEL.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jonatas Teodoro
 */
@WebServlet(name = "BuscarFila", urlPatterns = {"/BuscarFila"})
public class BuscarFila extends HttpServlet {

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

            int x = 0;

            FilaDAO dao;
            dao = new FilaDAO();
            int tipo = dao.buscarParamFila();
            String param = "";

            if (tipo == 0) {

            } else if (tipo == 1) {
                param = "AVIÃO";
            } else {
                param = "HELICÓPTERO";
            }

            dao = new FilaDAO();
            ArrayList<Fila> lista = dao.buscarFila(param);

            int posicao = 0;

            String json = "{\"posicao\" : \"" + posicao + "\", \"lista\" : [";

            for (Fila obj : lista) {
                if (x == 0) {
                    json = json + "{\"nome\" : \"" + obj.getNome() + "\", \"id\" : \"" + obj.getIdFila() + "\", \"tipo\" : \""+obj.getTipo()+"\"}";
                } else {
                    json = json + ", {\"nome\" : \"" + obj.getNome() + "\", \"id\" : \"" + obj.getIdFila() + "\", \"tipo\" : \""+obj.getTipo()+"\"}";
                }
                x++;
            }

            json = json + "]}";

            HttpServletResponse f = new HttpServletResponseWrapper(response);
            f.getWriter().print(json);

        } catch (Exception ex) {
            System.out.println("Erro ao BuscarFila!Erro: " + ex.getMessage());
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
