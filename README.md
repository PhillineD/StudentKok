# StudentIsDeKok 
Philline Dikker 12317608

De kookapp voor studenten met gevarieede, goedkope, makkelijke en voedzame avondmaaltijden. 

# Solution 
Studenten willen goedkoop, makkelijk en voedzame avondmaaltijden, alleen ontbreek de kennis en vaardigheid. Vaak kost het te veel tijd om dit op te zoeken op internet. Daarnaast vergeten studenten ook wat ze hebben gemaakt. Ook hebben ze geen smaken van andere cuturen. Er is nog geen oplossing in vorm van een app. De Studentisdekok-app biedt de oplossing. In deze app worden studenten-gerechten (goedkoop, makkelijk en voedzame avondmaaltijden) weergeven en is er een optie om te zien wat je al een keer hebt gemaakt en welke beoordeling je hieraan gegeven hebt. Ook kun je zoeken naar retjes die je nog in je koelkast hebt liggen om er voor te zorgen dat de kosten nog lager zijn. 

Minimale eisen:
-	Bieden van 2 opties: kookgeschiedenis en nieuwe gerechten proberen;
-	App gebruiker moet kunnen kiezen tussen de 3 V’s: vegetarisch, vis of vlees
-	Afhankelijk van de gekozen V moeten er gerechten verschijnen waar de gebruiker uit kan kiezen;
-	De gebruiker moet door de gerechten kunnen zoeken;
-	Door op een gerecht te klikken verschijnt het recept, de benodigdheden en een ratingbar;
-   De gebruiker kan een rating geven aan een bepaald gerecht door de ratingbar;
-	De kookgeschiedenis wordt weergegeven met de datum waarop het gerecht het laatst is gemaakt met de beoordeling;
-	Door de kookgeschiedenis kan gezocht worden;
-	De kookgeschiedenis staat op volgorde van beoordeling.

Extra:
-	De benodigdheden veranderen afhankelijk van het aantal personen dat mee eet;
- Extra gerechten; 
- Stopwatch functie;
- "geen idee" knop. 


![ontwerp](https://user-images.githubusercontent.com/43133057/48567161-b3c16a00-e8fc-11e8-968d-9a40754e775c.png)

# Voorwaarden 

Data:

De gerechten zullen gehaald worden van de open API database: https://www.themealdb.com. Hier staan allerlei gerechten in. Door er zelf een filter op te zetten ga ik er voor zorgen dat die alleen de goedkope, makkelijke en voedzame eruit haalt. 
Hiernaast komt er een SQL-database waarin de recent gemaakte gerechten worden opgeslagen (wanneer, welke rating). Ook gaat moet een een formule komen die kan berekenen voor hoeveel personen het gerecht is, dit staat namelijk niet in de database. 

Libery's:
- API
- SQL 

Reviews: 

Ik ben opzoek gegaan naar speciaal een app voor studenten om te kijken, maar die heb ik niet kunnen vinden. Daarnaast bestaan er wel veel kookapps die makkelijk in gebruik zijn, die studenten dus eventueel zouden kunnen gebruiken.

- Receptenmaker: Je kunt je eigen recepten beheren en recepten toevoegen van de bekende receptensites. Je kunt je recept sorteren op categorie, bereidingstijd, ingredient, receptnaam en bereiding. Ook hebben ze een kookwekker functie en een geen idee knop.  
    - Ik zou ook een kookwekker kunnen toevoegen, maar aangezien elke telefoon ook een stopwatch functie heeft lijkt me dit niet nodig. In mijn app kun je ook zoeken naar ingredienten en recepten, zoeken naar bereidingstijd lijkt me onnodig omdat ik alleen recepten sorteer uit mijn database die snel zijn. Ik heb geen "geen idee knop", dit lijkt me wel een goed idee als extra.
    
    ![image](https://user-images.githubusercontent.com/43133057/50723956-98e1c980-10e5-11e9-94b0-f51d2f0be018.png)
     

-  Fotokookboek: Fotokookboek is een app die aanvoelt als een kookcursus. Grote foto’s en begrijpelijke teksten laten je stap voor stap duidelijk zien welke ingrediënten je nodig hebt en hoe je ze bereidt. Fotokookboek leert je recepten uit de receptenverzameling Snel & simpel. Hier staan 60 recepten in die in 30 minuten of minder bereid kunnen worden. De app biedt nog negen andere kookboeken met ieder minimaal 60 recepten, zoals Italiaans, Aziatisch of Eenvoudig & lekker. Deze zijn niet gratis, maar wel per kookboek aan te schaffen in de app. De ingrediëntenlijst kan gedeeld worden met anderen.De lievelingsrecepten kan je bewaren als favoriet en ook kan je gemakkelijk notities toevoegen aan recepten. 
    - In vergelijking met mijn app is het start concept hetzelfde namelijk makelijk in gebruik. Bij mij kun je recepten ook als favoriet bewaren door ze een hoge rating te geven, maar ik heb geen notities. Ik zou aan mijn app nog notities kunnen toevoegen. 
    
    ![image](https://user-images.githubusercontent.com/43133057/50724079-b879f180-10e7-11e9-9217-3e1d7bd90fa2.png)
    
    
Moeilijkheden:
 - Het filteren van de database op goedkoop, makkelijk en voedzame avondmaaltijden. Ik wil dit gaan doen door het aantal ingredienten  en aantal kookstappen te tellen, als dit te lang is dan deze niet kiezen. 
 - 
    
    
    



