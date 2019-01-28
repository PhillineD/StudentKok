# StudentIsDeKok 

De kookapp voor studenten met gevarieede, goedkope, makkelijke en voedzame avondmaaltijden. 

Philline Dikker 12317608
Native App Studio
Minor Programmeren 
Universiteit van Amsterdam 

# Probleem

Studenten willen goedkoop, makkelijk en voedzame avondmaaltijden, alleen ontbreek de kennis en vaardigheid. Vaak kost het te veel tijd om dit op te zoeken op internet. Daarnaast vergeten studenten ook wat ze hebben gemaakt. Ook hebben ze geen idee van smaken van andere cuturen. Er is nog geen oplossing in vorm van een app. De Studentisdekok-app biedt de oplossing. In deze app worden studenten-gerechten (goedkoop, makkelijk en voedzame avondmaaltijden) weergeven en is er een optie om te zien wat je al een keer hebt gemaakt en welke beoordeling je hieraan gegeven hebt. Ook kun je zoeken naar retjes die je nog in je koelkast hebt liggen om er voor te zorgen dat de kosten nog lager zijn. 

# Oplossing

De kookapp voor studenten met gevarieede, goedkope, makkelijke en voedzame avondmaaltijden. 

<b>Minimale eisen:</b>

Startscherm
-	Bieden van 2 opties: "Kookgeschiedenis" en "Probeer iets nieuws";

Probeer iets nieuws
-	Na het klikken op "Probeer iets nieuws" moet de gebruiker kunnen kiezen tussen de 3 V’s: vegetarisch, vis of vlees;
-	Afhankelijk van de gekozen "V" moeten er gerechten verschijnen (naam van gerecht en foto) waar de gebruiker uit kan kiezen;
-	De gebruiker moet door de gerechten kunnen zoeken op receptnaam of producten;
-	Door op een gerecht te klikken verschijnt het recept, de benodigdheden en een ratingbar;
-   De gebruiker kan een rating geven aan een bepaald gerecht door de ratingbar;
-   Als het gerecht al een keer is gemaakt, staat de rating van de vorige keer er nog, deze kun je weer aanpassen;
-   Wanneer de rating wordt bevestigd, wordt ook dit gerecht toegevoegd aan de kookgeschiedenis. 

Kookgeschiedenis
-   Kookgeschiedenis geeft de gemaakte gerechten met datum van maken gesorteerd op rating die tijdends het maken is gegeven;
-   Als het recept in de kookgeschiedenis vaker is gemaakt dan staat de meeste recente datum erin;
-   Kookgeschiedenis heeft ook een zoekfunctie waarmee gezocht kan worden naar receptnamen; 


<b>Extra:</b>
-	De benodigdheden veranderen afhankelijk van het aantal personen dat mee eet;
-   Als je op een item in de geschiedenis klikt, ga je naar het recept;
-   Stopwatch functie, hiermee je tijd bijhouden voor bijvoorbeeld een oven-recept;
-   Notitie optie, wanneer er punten zijn die belangrijk zijn om te onthouden zie je die volgende keer als je dit gerecht maakt weer;
-   "geen idee" knop toevoegen aan startscherm, die een random gerecht kiest;
-   Link naar youtube filmpje.

<b>Schets:</b>
![overzichtschermen](https://user-images.githubusercontent.com/43133057/51831563-afe59700-22f2-11e9-920d-35aebf17cbf1.png)
![final_classes](https://user-images.githubusercontent.com/43133057/51831571-b3791e00-22f2-11e9-854d-b6eb81006df1.png)

# Voorwaarden 

<b>Data:</b>

De gerechten zullen gehaald worden van de open API database: https://www.themealdb.com. Hier staan allerlei gerechten in. Door er zelf een filter op te zetten ga ik er voor zorgen dat die alleen de goedkope, makkelijke en voedzame eruit haalt. 
Hiernaast komt er een SQL-database waarin de recent gemaakte gerechten worden opgeslagen (wanneer, welke rating). Ook gaat moet een een formule komen die kan berekenen voor hoeveel personen het gerecht is, dit staat namelijk niet in de database. 

<b>Libery's:</b>
- API themealdb
- SQLite database

    
<b>Moeilijkheden:</b>
 - Het filteren van de database op goedkoop, makkelijk en voedzame avondmaaltijden. Ik wil dit gaan doen door het aantal ingredienten  en aantal kookstappen te tellen, als dit te lang is dan deze niet kiezen. Ook wil ik kijken naar de ingredienten, als er een duur ingredient in staat, word dit recept niet gebruikt. Als dit niet lukt ga ik opzoek naar een andere data-base, of maak ik er zelf een aan. De concenquentie zal dan wel zijn dat ik weinig gerechten heb omdat ik ze zelf allemaal in de data-base moet zetten;
 - Het berekenen van het aantal personen wat van een gerecht kan eten;
 - De tijd van het laatst gemaakte gerecht onthouden en overschrijden; 
 - Kookgeschiedenis moet nog aanwezig zijn bij het opnieuw opstarten van de app. 
    
    
    



