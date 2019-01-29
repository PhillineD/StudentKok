# Final Report

*Student cheff*                                                                                                                          
Philline Dikker   12317608                                                                                                                               
Minor Programmeren                                                                                                                         
Universiteit van Amsterdam                                                                                                                  
Youtubelink : https://youtu.be/13M90853j-w

# Samenvatting

De kookapp voor studenten met gevarieede, goedkope, makkelijke en voedzame avondmaaltijden. 
      
<img src="https://user-images.githubusercontent.com/43133057/51832704-b6294280-22f5-11e9-8279-09b37c6b22bb.png" width="20%" height="20%">

# Oplossing/ gebruik

<b>Startscherm</b>
-	Bieden van 2 opties: "Kookgeschiedenis" en "Probeer iets nieuws";
-   Wanneer men op het internet icoontje klikt, opent TheMealsDatabase.com, waar alle gerechten vandaan komen;
-   Wanneer men op het i klikt, opent een pop-up met informatie.

<b>Probeer iets nieuws</b>
-	Na het klikken op "Probeer iets nieuws" moet de gebruiker kunnen kiezen tussen vegetarisch, veganistisch, vis of vlees;
-   Ook is er een mogelijkheid om een random categorie te kiezenl;
-   Wanneer men klikt op vlees, verschijnen de verschillende opties voor vlees;
-	Afhankelijk van de gekozen categorie moeten er gerechten verschijnen (naam van gerecht en foto) waar de gebruiker uit kan kiezen;
-	De gebruiker moet door de gerechten kunnen zoeken op (deel van) receptnaam;
-	Door op een gerecht te klikken verschijnt de benodigdheden, de instructies, ratingbar, vakje om in te vullen hoe lang je er over         gedaan hebt;
-   Door op het video icoontje te klikken, opent er een video van het recept in Youtube;
-   De gebruiker kan een rating geven aan een bepaald gerecht door de ratingbar;
-   Wanneer de gebruiker klaar is en op het opslaan icoontje klikt, wordt ook dit gerecht toegevoegd aan de kookgeschiedenis. 

<b>Kookgeschiedenis</b>
-   Kookgeschiedenis geeft de gemaakte gerechten met datum van maken gesorteerd op rating die tijdends het maken is gegeven;
-   Als het recept in de kookgeschiedenis vaker is gemaakt dan staat de meeste recente datum, rating  en kooktijd erin;
-   Kookgeschiedenis heeft ook een zoekfunctie waarmee gezocht kan worden naar receptnamen, categorieen en hoe lang het koken duurde; 
-   Als je op een item in de geschiedenis klikt, krijgt je het recept, er zal nu weer een nieuwe kooktijd en rating moeten worden       toegevoegd.

# Technisch design

<b>Overzicht</b>

![overzichtschermen](https://user-images.githubusercontent.com/43133057/51831563-afe59700-22f2-11e9-920d-35aebf17cbf1.png)

<b>Uitwerking per functie</b>

- Informatie pop-up en link naar internet site van database.
      <img src="https://user-images.githubusercontent.com/43133057/51837087-9ea48680-2302-11e9-8c26-ddc391eceeaa.png" width="75%" height="75%">


- Keuze menu's.                                                                                                                           
      <img src="https://user-images.githubusercontent.com/43133057/51837089-9ea48680-2302-11e9-850b-2b98285a1ee8.png" width="75%" height="75%">
  
         
- Lijst met gerechten van gekozen categorie.                                                                                               
      <img src="https://user-images.githubusercontent.com/43133057/51837090-9f3d1d00-2302-11e9-89de-897f10cb3512.png" width="75%" height="75%">
      
    
- Recept van gekozen gerecht.                                                                                                                    
      <img src="https://user-images.githubusercontent.com/43133057/51837093-9f3d1d00-2302-11e9-83f0-b4dbd73efda0.png" width="75%" height="75%">
      

- Opslaan data van recept.                                                                                                                                                       
      <img src="https://user-images.githubusercontent.com/43133057/51837094-9f3d1d00-2302-11e9-81ad-fb58e99c8414.png" width="75%" height="75%">
      

- Geschiedenis weergeven.                                                                                                                                 
      <img src="https://user-images.githubusercontent.com/43133057/51837095-9f3d1d00-2302-11e9-9cf1-93e58c141c0d.png" width="75%" height="75%">
      


<b>Samenwerking classes</b>

   <img src="https://user-images.githubusercontent.com/43133057/51831571-b3791e00-22f2-11e9-854d-b6eb81006df1.png" width="75%" height="75%">
   
*Activity’s* 

- StartActivity:
	- navigatie naar "try something new";
	- nagigatie naar "history";
	- pop-up van informatie, popup_history.xml;
	- intent naar internet voor site van database;

- HistoryActivity
	- vult de listview van history_activity.xml met history_item.xml door middel van de EntryAdapter.java;
	- onclick, voor als op een history_item.xml wordt geklikt, id woord doorgegeven;
	- zoekfunctie, door middel van de functie "filterData" van EntryDatabase;
	
- MealsActivity
	- aan de hand van een gekregen categorie, een MealsRequest;
	- on click, voor als op  meals_item.xml is geklikt;
	- gotMeals, als de mealsrequest is gelukt, vult listview van meals_activity.xml met gekregen meals_item.xml
	- got MealsError, als het ophalen van meals mislukt is; 
	- in de gotMeals, als er getypt word in de zoekbalk, filter functie vanuit MealAdapter
	
- MeatActivity
	- het doorgeven van de juiste categorie ( Beef, Pork, Chicken, Lamb of Random) aan de hand van de geklikte button op meat_activity.xml;

- VActivity
	- het doorgeven van de juiste gekozen catergorie ( Random, Meat, Fish, Vega, Vegan) aan de hand van de geklikte bbutton op V_activity.xml ;
	
- RecipeActivity
	- met gekregen id een RecipeRequest aanvragen;
	- navigatie naar Youtube als er gelikt is op het video'tje;
	- onclick on van afrondingsknop, vult een item in de database (EntryDatabase) en checkt of alles goed is ingevuld; 
	- gotRecipe voor als RecipeRequest goed is gegaan, vult de scrollview in van recipe_activity.xml;
	- gotRecipeError voor als request fout is gegaan;
	
*Adapters*
- EntryAdapter
	- aan de hand van een view het vullen van history_item.xml;
	
- MealAdapter
	- aan de hand van een view het vullen van meals_item.xml;
	- filterfunctie voor de SearchView in meals_activity.xml;
	
*Extra*
- DowloadImageTask
	- weergeven van plaatjes in heel de app;
	

*Models*
- Meal
	- model voor het recept;

- MealItem
	- model voor het gerecht;
	
*Request*
- MealsRequest
	- getMeals voor jsonObjectRequest met juiste categorie;
	- onResponse het krijgen van JSONArray en het vullen van MealItems;
	
- RecipeRequest
	- getRecipe voor jsonObjectRequest met juiste id van het recept;
	- onResponse het krijgen van JSONArray en het vullen van Meal;
	
- EntryDatabase
	- maakt een database;
	- insert voor toevoegen aan database;
	- filterData voor het zoeken in history_activity.xml;
	

	
*Layouts*
- history_activity.xml
- history_item.xml
- meals_activity.xml
- meals_item.xml
- meat_activity.xml
- start_activity.xml
- popup_history.xml
- V_activity.xml
- recipe_activity.xml

<b>API request</b>

Afhankelijk van de gekozen catergorie worden deze API’s gebruikt. Uit deze lijst wordt een gerecht met een bepaald id gekozen.
The Meal Database geeft ons verschillende catergorieen (c). Ik heb de bruikbare gekozen per catergorie, zie hieronder. 

*Fish*
  - https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood

*Meat*  
 - https://www.themealdb.com/api/json/v1/1/filter.php?c=Beef
 - https://www.themealdb.com/api/json/v1/1/filter.php?c=Chicken
 - https://www.themealdb.com/api/json/v1/1/filter.php?c=Lamb
 - https://www.themealdb.com/api/json/v1/1/filter.php?c=Pork

*Vegan*  
 - https://www.themealdb.com/api/json/v1/1/filter.php?c=Vegan
 
 *Vega*  
 - https://www.themealdb.com/api/json/v1/1/filter.php?c=Vegeterain


Het id wordt hieronder ingevuld. 
 - https://www.themealdb.com/api/json/v1/1/lookup.php?=”MealId”


<b>Database</b>

Om de gebruikersgeschiedenis op te slaan gaan we een SQLite Database aanmaken in de telefoon. Deze moet er als onderstaande tabel gaan uitzien.

<table>
	<tr>
		<th>Meal id </th>
		<th>Rating </th>
		<th>Picture </th>
            <th>Hint </th>
            <th>Time </th>
            <th>Timestamp </th>
	</tr>
	<tr>
		<td> 12345      </td>
		<td> 3.0    </td>
		<td> url.png      </td>
		<td> Seafood      </td>
		<td> 132      </td>
		<td> 22-08-2019      </td>
	</tr>

</table>

- Meal id als string;
- Rating als integer; 
- Picuture als string.
- Hint als string;
- Time als float;
- Timestamp als TIME;


# Uitdagingen 

-  Na het klikken op vlees en vega, verschijnen er nieuwe schermen met: 
	- Vlees; pork, lam, chicken
	- Vega; vegan, vega  
	Uit deze opties kan weer gekozen worden, zodat er minder gerechten verschijnen en dat de recepten specifieker zijn. 
	Het klikken op het filmpje bij recept moet een filmpje geven, dit maakt ze app gebruiksvriendelijker;
- De video kan bekeken worden door op de knop video te klikken, dan is het duidelijk hoe de gebruiker aan de video komt;
	- eerst moest er op het plaatje geklikt worden, dit is niet duidelijk.
- Vanuit een item in de history, kun je door het klikken weer naar het recept van het aangeklikte item gaan. 
	- Hierdoor hoeft de gebruiker niet meer in de gerechten te gaan zoeken om naar een recept te gaan;
- Random knoppen bij de keuzes;
	- maakt het kiezen makkelijker;
- Als je vanuit history of vanuit “try something new” bij een recept komt, moet je een nieuwe rating aangeven. 
	- Dit doe je omdat als je een gerecht voor de tweede keer maakt, hij lekkerder kan zijn. De oude rating zal niet weergeven zijn omdat dit de nieuwe rating eventueel kan beinvloeden;
- De zoekboxen worden edittexten, omdat je dan al na het typen van 1 letter kan zoeken. 
	- Dit is makkelijker en sneller voor de gebruiker;
- In history kun je ook zoeken naar de categorie van een gerecht bijvoorbeeld vega
	- Hierdoor kun je makkelijker een gerecht terug vinden;
- Het zoeken van in de history word gedaan door een Edittext en een knop
	- Werkt beter voor databases;
- Je kunt bij het recept aangeven hoe lang je erover hebt gedaan, dit word daarna (als de rating ook is ingevuld) ook weergeven in history. 
	- Zo kunnen gebruikers gelijk zien hoeveel tijd het waarschijnlijk gaat kosten;
- De VeganActivity is gecombineerd met de V activty 
	- Minder schermen voor de gebruiker;
- Er zal worden aangenomen dat de hoeveelheden gelijk zijn aan de hoeveelheden op het plaatje;
	- In de dataset staat hier niks over, voor duidelijke van de gebruiker zal er toch iets over gezegd moeten worden;
- StartActivity heeft een internet knop, als je hier op klikt word je doorverwezen naar de site van de data. 
	- Hierdoor weet de gebruiker waar alle gerechten vandaan komen.
