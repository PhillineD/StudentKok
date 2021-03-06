# StudentIsDeKok 

De kookapp voor studenten met gevarieede, goedkope, makkelijke en voedzame avondmaaltijden. 

Philline Dikker 12317608
Native App Studio
Minor Programmeren 
Universiteit van Amsterdam 

# Probleem

Studenten willen goedkoop, makkelijk en voedzame avondmaaltijden, alleen ontbreek de kennis en vaardigheid. Vaak kost het te veel tijd om dit op te zoeken op internet. Daarnaast vergeten studenten ook wat ze hebben gemaakt. Ook hebben ze geen idee van smaken van andere cuturen. Er is nog geen oplossing in vorm van een app. De Studentisdekok-app biedt de oplossing. In deze app worden studenten-gerechten (goedkoop, makkelijk en voedzame avondmaaltijden) weergeven en is er een optie om te zien wat je al een keer hebt gemaakt en welke beoordeling je hieraan gegeven hebt. 

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
![ontwerp](https://user-images.githubusercontent.com/43133057/48567161-b3c16a00-e8fc-11e8-968d-9a40754e775c.png)
studentkok/doc/ontwerp
# Voorwaarden 

<b>Data:</b>

De gerechten zullen gehaald worden van de open API database: https://www.themealdb.com. Hier staan allerlei gerechten in. Door er zelf een filter op te zetten ga ik er voor zorgen dat die alleen de goedkope, makkelijke en voedzame eruit haalt. 
Hiernaast komt er een SQL-database waarin de recent gemaakte gerechten worden opgeslagen (wanneer, welke rating). Ook gaat moet een een formule komen die kan berekenen voor hoeveel personen het gerecht is, dit staat namelijk niet in de database. 

<b>Libery's:</b>
- API themealdb
- SQLite database

<b>Reviews:</b> 

Ik ben opzoek gegaan naar speciaal een app voor studenten , maar die heb ik niet kunnen vinden. Er bestaan er wel veel kookapps die makkelijk in gebruik zijn, die studenten dus eventueel zouden kunnen gebruiken.

- Receptenmaker: Je kunt je eigen recepten beheren en recepten toevoegen van de bekende receptensites. Je kunt je recept sorteren op categorie, bereidingstijd, ingredient, receptnaam en bereiding. Ook hebben ze een kookwekker functie en een geen idee knop.  
    - Ik zou ook een kookwekker kunnen toevoegen, maar aangezien elke telefoon ook een stopwatch functie heeft lijkt me dit niet nodig. In mijn app kun je ook zoeken naar ingredienten en recepten, zoeken naar bereidingstijd lijkt me onnodig omdat ik alleen recepten sorteer uit mijn database die snel zijn. Ik heb geen "geen idee knop", dit lijkt me wel een goed idee als extra.
    
          
         <img src="https://user-images.githubusercontent.com/43133057/50723956-98e1c980-10e5-11e9-94b0-f51d2f0be018.png" width="20%" height="20%"/>

     

-  Fotokookboek: Fotokookboek is een app die aanvoelt als een kookcursus. Grote foto’s en begrijpelijke teksten laten je stap voor stap duidelijk zien welke ingrediënten je nodig hebt en hoe je ze bereidt. Fotokookboek leert je recepten uit de receptenverzameling Snel & simpel. Hier staan 60 recepten in die in 30 minuten of minder bereid kunnen worden. De app biedt nog negen andere kookboeken met ieder minimaal 60 recepten, zoals Italiaans, Aziatisch of Eenvoudig & lekker. Deze zijn niet gratis, maar wel per kookboek aan te schaffen in de app. De ingrediëntenlijst kan gedeeld worden met anderen.De lievelingsrecepten kan je bewaren als favoriet en ook kan je gemakkelijk notities toevoegen aan recepten. 
    - In vergelijking met mijn app is het start concept hetzelfde namelijk makelijk in gebruik. Bij mij kun je recepten ook als favoriet bewaren door ze een hoge rating te geven, maar ik heb geen notities. Ik zou aan mijn app nog notities kunnen toevoegen. 
    
         <img src="https://user-images.githubusercontent.com/43133057/50724079-b879f180-10e7-11e9-9217-3e1d7bd90fa2.png" width="20%" height="20%"/>


    
<b>Moeilijkheden:</b>
 - Het filteren van de database op goedkoop, makkelijk en voedzame avondmaaltijden. Ik wil dit gaan doen door het aantal ingredienten  en aantal kookstappen te tellen, als dit te lang is dan deze niet kiezen. Ook wil ik kijken naar de ingredienten, als er een duur ingredient in staat, word dit recept niet gebruikt. Als dit niet lukt ga ik opzoek naar een andere data-base, of maak ik er zelf een aan. De concenquentie zal dan wel zijn dat ik weinig gerechten heb omdat ik ze zelf allemaal in de data-base moet zetten;
 - Het berekenen van het aantal personen wat van een gerecht kan eten;
 - De tijd van het laatst gemaakte gerecht onthouden en overschrijden; 
 - Kookgeschiedenis moet nog aanwezig zijn bij het opnieuw opstarten van de app. 
    
    
    
