/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NewsDAO;
import entity.News;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class SearchCointroller extends HttpServlet {

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
        try {
            NewsDAO newsDAO = new NewsDAO();
            //get searching input title 
            String title = request.getParameter("txtSearch").trim();
            // tilte is empty 
            if (title.isEmpty()) {
                request.setAttribute("error", "title must be not null");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                //get page index
                String pageIndex = request.getParameter("index");
                //default page index=1
                if (pageIndex == null) {
                    pageIndex = "1";
                }
                int index = Integer.parseInt(pageIndex);
                //count total page 
                int total = newsDAO.countTotalPage(title);

                //total page is null 
                if (total == 0) {
                    request.setAttribute("error", "Not found");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                } else {
                    // set page size = 3 
                    int pageSize = 3;
                    int maxPage = total / pageSize;
                    if (total % pageSize != 0) {
                        maxPage++;
                    }
                    List<News> listSearch = newsDAO.searchByTitle(title, index, pageSize);
                    int size = listSearch.size();
                    request.setAttribute("listSearch", listSearch);

                    request.setAttribute("maxPage", maxPage);
                    request.setAttribute("txt", title);
                    request.setAttribute("index", index);

                    List<News> list = newsDAO.getTop5();
                    request.setAttribute("listTop5", list);
                    request.getRequestDispatcher("searchPage.jsp").forward(request, response);
                }

            }
        } catch (Exception e) {
            request.setAttribute("error1", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);

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
