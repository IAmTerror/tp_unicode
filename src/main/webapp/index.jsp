<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<h2>Table de caractères Unicode</h2>

<form method="get" action="table">
    <p>Choisissez un système de représentation des codes numériques :</p>

    <div class="formulaire">
        <div class="radio">
            <label for="decimal">Décimal</label><input checked id="decimal" name="type" value="decimal" type="radio">
            <label for="hexadecimal">Hexadécimal</label><input id="hexadecimal" name="type" value="hexadecimal"
                                                               type="radio">
        </div>

        <p>Paramétrez manuellement une plage... :</p>
        <div>
            <label for="debut">Début : </label><input id="debut" type="text" name="debut">
        </div>
        <br/>
        <div>
            <label for="fin">Fin : </label><input id="fin" type="text" name="fin">
        </div>
        <br/>
        <div>
            <label for="titre">Titre : </label><input id="titre" type="text" name="titre">
        </div>

        <p>... ou bien, sélectionnez une plage prédéfinie :</p>
        <div class="langue">
            <SELECT name="langue" size="1">
                <option></option>
                <OPTION>Arabe</option>
                <OPTION>Tibétain</option>
                <OPTION>Katakana</option>
                <OPTION>Hiragana</option>
            </SELECT>
            <br/>
            <br/>
            <button type="submit" name=go">Envoyer</button>
        </div>

    </div>

</form>

</body>
</html>