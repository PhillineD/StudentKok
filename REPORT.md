# Final Report

- Student cheff
- Philline Dikker
- Minor Programmeren 
- Universiteit van Amsterdam


# Samenvatting

De kookapp voor studenten met gevarieede, goedkope, makkelijke en voedzame avondmaaltijden. 
      
<img src="https://user-images.githubusercontent.com/43133057/51832704-b6294280-22f5-11e9-8279-09b37c6b22bb.png" width="20%" height="20%">

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
	- pop-up van informatie;
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
	- het doorgeven van de juiste categorie aan de hand van de geklikte button op meat_activity.xml;
	
- StartActivity
	- start_activity.xml
	- popup_history.xml
- VActivity
	- V_activity.xml
- RecipeActivity
	- recipe_activity.xml
	
*Adapters*
- EntryAdapter
- MealAdapter

*Extra*
- DowloadImageTask

*Models*
- Meal
- MealItem

*Request*
- MealsRequest
- RecipeRequest
- EntryDatabase

	
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

# Refelectie
