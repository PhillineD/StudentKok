# Design document 

# Geavanceerde schetsen van de gebruikersinterface

![design1](https://user-images.githubusercontent.com/43133057/50820657-878afe00-132d-11e9-8770-fba02b849740.png)
![design2](https://user-images.githubusercontent.com/43133057/50820658-878afe00-132d-11e9-9080-9297b46e4106.png)

# Een diagram van gebruiksmodules, klassen en functies

# Een lijst met API's en frameworks

Afhankelijk van de gekozen catergorie worden deze API’s gebruikt. Uit deze lijst wordt een gerecht met een bepaald id gekozen.


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

Daarnaast bestaat er ook
- https://www.themealdb.com/api/json/v1/1/filter.php?c=Pasta
Deze moet ontleedt worden om in een van de bovenstaande V's ingedeeld te worden.

Het id wordt hieronder ingevuld. 
 - https://www.themealdb.com/api/json/v1/1/lookup.php?=”MealId”



Ik heb getest in CS50 IDE of the API toegankelijk was. Ik vroeg het gerecht Arribata of en ontving de juiste informatie.
![testing api](https://user-images.githubusercontent.com/43133057/50821626-f8331a00-132f-11e9-81a0-bec080b8025a.png)
Ook heb ik gegeken of de plaatjes goed waren, zo gaf de link: https://www.themealdb.com//images//media//meals//xutquv1505330523.jpg
![voorbeeld plaatje](https://user-images.githubusercontent.com/43133057/50823459-56fa9280-1334-11e9-9c17-af86a440684b.jpg)

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
