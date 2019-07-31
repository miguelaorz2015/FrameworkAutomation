Feature: Access Expedia and Look for Flights

Scenario: Look for Flights
	Given User is on Home Page
	When User Look For Flights Round Trip
	And User Enters Source as "JFK"
	And User Enters Destination as "ORD"
	And User Enters Departing date
	And User Enters Returning date
	Then User Click On Search Button
	Then User Displayed Successfully Search 
	Then User Sort by Departure Earliest flight
	Then User Select an early departing flight.
	Then User Sort by an Arrival Earliest for selecting return flight 
	Then User Select an Arrival Earliest flight
	Then User Continue as Guest for booking
	
	
