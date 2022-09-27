/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ca.sait.servlets;

import ca.sait.models.Note;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author dom
 */
@WebServlet(name = "NoteServlet", urlPatterns = {"/note"})
public class NoteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *

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
    
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        FileReader in = new FileReader(path);
        BufferedReader br = new BufferedReader(in);
        
        Note newNote = new Note();
        
        newNote.setTitle(br.readLine());
        
        do{
            newNote.setContents(newNote.getContents() + br.readLine() + "<br>");
        } while(br.readLine() != null);
       
        
        request.setAttribute("title", newNote.getTitle());
        request.setAttribute("contents", newNote.getContents());
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        
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
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter out = new PrintWriter(path);
        Scanner in = new Scanner(new File(path));
        
        Note n = new Note();
        
        n.setTitle(request.getParameter("title"));
        n.setContents(request.getParameter("contents"));
        
        String oldTitle = in.nextLine();
        String newTitle = oldTitle.replaceAll(oldTitle, n.getTitle());
        out.println(newTitle);
        in.nextLine();
        
        String oldContents = in.nextLine();
        String newContents = oldContents.replaceAll(oldContents, n.getContents());
        out.println(newContents);
        
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
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
