package fr.iat.unicode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;


public class UnicodeApp extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // -------------------------------------------------------------------------------------------------------------
        // RECUPERATION DES PARAMETRES
        // -------------------------------------------------------------------------------------------------------------
        String type = request.getParameter("type");
        String langue = request.getParameter("langue");
        String debut = request.getParameter("debut");
        String fin = request.getParameter("fin");
        String titre = request.getParameter("titre");


        // hashmap ordonnée : clé = affichage en décimal ou hexa selon choix de l'utilisateur ; valeur = code Unicode
        LinkedHashMap<String, Integer> codes = new LinkedHashMap<>();

        int plageDebut = 0;
        int plageFin = 0;


        // -------------------------------------------------------------------------------------------------------------
        // GESTION DES ENTREES DE L'UTILISATEUR + DEFINITION DES PLAGES UNICODE
        // -------------------------------------------------------------------------------------------------------------
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
            int plageDebutControl = Integer.valueOf(debut);
            int plageFinControl = Integer.valueOf(fin);
            if (plageDebutControl < plageFinControl) {
                plageDebut = plageDebutControl;
                plageFin = plageFinControl;
            } else {
                plageDebut = 33;
                plageFin = 255;
            }
        } else  {
            plageDebut = 33;
            plageFin = 255;
        }


        // -------------------------------------------------------------------------------------------------------------
        // CONVERSION DES PLAGES EN VALEURS DECIMALES OU HEXADECIMALES
        // -------------------------------------------------------------------------------------------------------------
        for (int i = plageDebut ; i <= plageFin ; i++) {
            if (type.equals("hexadecimal")) {
                String hexadecimal = Integer.toHexString(i);
                codes.put(hexadecimal, i);
            }

            else if (type.equals("decimal")) {
                String decimal = Integer.toString(i);
                codes.put(decimal, i);
            }
        }


        // -------------------------------------------------------------------------------------------------------------
        // GESTION DE LA VUE
        // -------------------------------------------------------------------------------------------------------------
        // pour les besoins de la vue
        request.setAttribute("codes", codes);
        request.setAttribute("titre", titre);
        // délégation à la vue
        String laVue = "table-unicode.jsp";
        getServletConfig().getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/"+laVue).forward(request, response);
    }
}
