# Design document 

Op basis van het voorstel een meer technische uitwerking van de StudentIsDeKok. De afzonderlijke delen van de oplossing in kaart, API's, database en een diagram van gebruikersmodules, klassen en functies. 

Alle onderdelen zijn nu in het Nederlands uitgewerkt maar de uiteindelijk versie zal in het Engels zijn. Hiervoor heb ik gekozen omdat de data ook in Engels is. De app zal dan ook geen StudentIsDeKok heten maar Studentchef. 


# Geavanceerde schetsen van de gebruikersinterface

![design1](https://user-images.githubusercontent.com/43133057/50820657-878afe00-132d-11e9-8770-fba02b849740.png)
![design2](https://user-images.githubusercontent.com/43133057/50820658-878afe00-132d-11e9-9080-9297b46e4106.png)

# Een diagram van gebruiksmodules, klassen en functies

![diagram](https://user-images.githubusercontent.com/43133057/50828171-e9a12e80-1340-11e9-9334-60012902bb29.png)

# Een lijst met API's en frameworks

Afhankelijk van de gekozen catergorie worden deze API’s gebruikt. Uit deze lijst wordt een gerecht met een bepaald id gekozen.
The Meal Database geeft ons verschillende catergorieen (c). Ik heb de bruikbare gekozen per catergorie, zie hieronder. 

*Vis*
  - https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood

*Vlees*  
 - https://www.themealdb.com/api/json/v1/1/filter.php?c=Beef
 - https://www.themealdb.com/api/json/v1/1/filter.php?c=Chicken
 - https://www.themealdb.com/api/json/v1/1/filter.php?c=Lamb
 - https://www.themealdb.com/api/json/v1/1/filter.php?c=Pork

*Vega*  
 - https://www.themealdb.com/api/json/v1/1/filter.php?c=Vega
 - https://www.themealdb.com/api/json/v1/1/filter.php?c=Vegaterain

Overig
- https://www.themealdb.com/api/json/v1/1/filter.php?c=Pasta

Deze moet ontleedt worden om in een van de bovenstaande V's ingedeeld te worden.

Het id wordt hieronder ingevuld. 
 - https://www.themealdb.com/api/json/v1/1/lookup.php?=”MealId”



Ik heb getest in CS50 IDE of the API toegankelijk was. Ik vroeg het gerecht Arribata of en ontving de juiste informatie.

![testing api](https://user-images.githubusercontent.com/43133057/50821626-f8331a00-132f-11e9-81a0-bec080b8025a.png)

Ook heb ik gegeken of de plaatjes goed waren, zo gaf de link:
- https://www.themealdb.com//images//media//meals//xutquv1505330523.jpg

Dit plaatje:

<img src="https://user-images.githubusercontent.com/43133057/50823459-56fa9280-1334-11e9-9c17-af86a440684b.jpg" width="20%" height="20%"/>


In de data staan ook youtube linkjes een filmpje van het recept. "strMeal":"Spicy Arrabiata Penne", geeft deze link:

- https://www.youtube.com/watch?v=1IszT_guI08
,dit is het juiste recept. 

# Database tabellen 

Om de gebruikersgeschiedenis op te slaan gaan we een SQLite Database aanmaken in de telefoon. Deze moet er als onderstaande tabel gaan uitzien.

<table>
	<tr>
		<th>Meal id </th>
		<th>Rating </th>
		<th>Date </th>
	</tr>
	<tr>
		<td> 12345      </td>
		<td> 3          </td>
		<td> 7-1-2019   </td>
	</tr>
	<tr>
		<td> 64576      </td>
		<td> 2          </td>
		<td> 9-1-2019   </td>
	</tr>
	<tr>
		<td> 92345      </td>
		<td> 3          </td>
		<td> 11-1-2019  </td>
	</tr>
	<tr>
		<td> 12775      </td>
		<td> 5          </td>
		<td> 4-1-2019   </td>
	</tr>
</table>

- Meal id als string;
- Rating als integer; 
- Date als string.
