package fr.iat.unicode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class UnicodeApp extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        String langue = request.getParameter("langue");
        String debut = request.getParameter("debut");
        String fin = request.getParameter("fin");
        String titre = request.getParameter("titre");

        LinkedHashMap<String, Integer> codes = new LinkedHashMap<>();

        int plageDebut = 0;
        int plageFin = 0;

        if(!langue.equals("") && debut.equals(("")) && fin.equals((""))){
            switch (langue.toLowerCase()) {
                case "arabe":
                    plageDebut = 1536;
                    plageFin = 1791;
                    break;
                case "tibetain":
                    plageDebut = 3840;
                    plageFin = 4058;
                    break;
                case "katakana":
                    plageDebut = 12448;
                    plageFin = 12543;
                    break;
                case "hiragana":
                    plageDebut = 12352;
                    plageFin = 12447;
                    break;
            }
        } else if (langue.equals("") && !debut.equals(("")) && !fin.equals((""))) {
            plageDebut = Integer.valueOf(debut);
            plageFin = Integer.valueOf(fin);
        } else  {
            plageDebut = 33;
            plageFin = 255;
        }


        for (int i = plageDebut ; i <= plageFin ; i++) {
            if (type.equals("hexadecimal")) {
                String hexadecimal = Integer.toHexString(i);
                codes.put(hexadecimal, i);
            }

            if (type.equals("decimal")) {
                String decimal = Integer.toString(i);
                codes.put(decimal, i);
            }
        }


        // pour les besoins de la vue
        request.setAttribute("codes", codes);
        // délégation à la vue
        String laVue = "table-unicode.jsp";
        getServletConfig().getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/"+laVue).forward(request, response);
    }
}
