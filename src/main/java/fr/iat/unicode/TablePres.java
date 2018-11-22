package fr.iat.unicode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class TablePres extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");

//        ArrayList<String> codeAsciiFormate = new ArrayList();
//        ArrayList<Integer> codeAscii = new ArrayList();
        LinkedHashMap<String, Integer> codes = new LinkedHashMap<>();


        for (int i=33 ; i <= 255 ; i++) {
            if (type.equals("hexadecimal")) {
                String hexadecimal = Integer.toHexString(i);
//                codeAsciiFormate.add(hexadecimal);
//                codeAscii.add(i);
                codes.put(hexadecimal, i);
            }

            if (type.equals("decimal")) {
                String decimal = Integer.toString(i);
//                codeAsciiFormate.add(decimal);
//                codeAscii.add(i);
                codes.put(decimal, i);
            }
        }

//        System.out.println(codeAsciiFormate);
//        System.out.println(codeAscii);
        System.out.println(codes);


        // pour les besoins de la vue
//        request.setAttribute("codeAsciiFormate", codeAsciiFormate);
//        request.setAttribute("codeAscii", codeAscii);
        request.setAttribute("codes", codes);
        // délégation à la vue
        String laVue = "table-unicode.jsp";
        getServletConfig().getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/"+laVue).forward(request, response);
    }
}
