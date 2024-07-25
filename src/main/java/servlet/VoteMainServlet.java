package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.VoteDataBeans;

@WebServlet("/VoteMainServlet")
public class VoteMainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String event = request.getParameter("event");

        if (event == null) {
            response.sendRedirect("voteError.jsp");
            return;
        }

        VoteDataBeans voteData = (VoteDataBeans) getServletContext().getAttribute("voteData");

        if (voteData == null) {
            voteData = new VoteDataBeans();
            getServletContext().setAttribute("voteData", voteData);
        }

        voteData.addVote(event);
        request.setAttribute("eventData", voteData.getEventDataBeans());
        request.setAttribute("totalVotes", voteData.getTotalVotes());
        request.getRequestDispatcher("voteResult.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
